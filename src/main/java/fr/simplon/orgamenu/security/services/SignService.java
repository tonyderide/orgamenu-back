package fr.simplon.orgamenu.security.services;
import fr.simplon.orgamenu.models.ERole;
import fr.simplon.orgamenu.repository.UserRepository;
import fr.simplon.orgamenu.models.Role;
import fr.simplon.orgamenu.models.User;
import fr.simplon.orgamenu.payload.request.LoginRequest;
import fr.simplon.orgamenu.payload.request.SignupRequest;
import fr.simplon.orgamenu.payload.response.JwtResponse;
import fr.simplon.orgamenu.payload.response.MessageResponse;
import fr.simplon.orgamenu.repository.RoleRepository;
import fr.simplon.orgamenu.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SignService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    SignService signService;


    @Autowired
    PasswordEncoder encoder;


    public ResponseEntity<?> signinService(LoginRequest loginRequest) {

            Authentication authentication = this.authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));




            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = this.jwtUtils.generateJwtToken(authentication);

            HttpHeaders responseHeaders = new HttpHeaders();
            responseHeaders.set("Token",jwt);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            List<String> roles = userDetails.getAuthorities().stream()
                    .map(item -> item.getAuthority())
                    .collect(Collectors.toList());

            return ResponseEntity.ok()
                    .headers(responseHeaders)
                    .body(new JwtResponse(jwt,
                    userDetails.getId(),
                    userDetails.getUsername(),
                    userDetails.getEmail(),
                    userDetails.getFirstname(),
                    userDetails.getLastname(),
                    userDetails.getSize(),
                    userDetails.getWeight(),
                    userDetails.getAge(),
                    userDetails.getSexe(),
                    roles));
                    //TODO juste pour les tests plus rapide Token dans le header
//            return ResponseEntity.ok(new JwtResponse(jwt,
//                    userDetails.getId(),
//                    userDetails.getUsername(),
//                    userDetails.getEmail(),
//                    userDetails.getFirstname(),
//                    userDetails.getLastname(),
//                    userDetails.getSize(),
//                    userDetails.getWeight(),
//                    userDetails.getAge(),
//                    userDetails.getSexe(),
//                    roles));
        }



    public ResponseEntity<?> signupService(SignupRequest signUpRequest) {
        if (this.userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getFirstname(),
                signUpRequest.getLastname(),
                signUpRequest.getSize(),
                signUpRequest.getWeight(),
                signUpRequest.getAge(),
                signUpRequest.getSexe()
        );

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "user":
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}
