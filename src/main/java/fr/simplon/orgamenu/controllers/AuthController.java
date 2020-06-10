package fr.simplon.orgamenu.controllers;


import fr.simplon.orgamenu.payload.request.LoginRequest;
import fr.simplon.orgamenu.payload.request.SignupRequest;
import fr.simplon.orgamenu.payload.request.UpdateRequest;
import fr.simplon.orgamenu.repository.RoleRepository;
import fr.simplon.orgamenu.repository.UserRepository;
import fr.simplon.orgamenu.security.jwt.JwtUtils;
import fr.simplon.orgamenu.security.services.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    SignService signService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return this.signService.signinService(loginRequest);

    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        return this.signService.signupService(signUpRequest);

    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UpdateRequest updateRequest) {
        return this.signService.updateService(updateRequest);
    }
}
