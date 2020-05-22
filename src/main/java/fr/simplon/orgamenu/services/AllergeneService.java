package fr.simplon.orgamenu.services;

import fr.simplon.orgamenu.models.Allergene;
import fr.simplon.orgamenu.models.User;
import fr.simplon.orgamenu.repository.AllergeneRepository;
import fr.simplon.orgamenu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class AllergeneService {

    @Autowired
    AllergeneRepository allergeneRepository;
    @Autowired
    UserRepository userRepository;


    public List<Allergene> findAllergeneUser() throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println("-------------" + username + "------------");
        if (user.isPresent()) {
            return allergeneRepository.findAllByUsers_id(user.get().getId());
        }
        return allergeneRepository.findAll();
    }


}
