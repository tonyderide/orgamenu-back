package fr.simplon.orgamenu.services;

import fr.simplon.orgamenu.models.Allergene;
import fr.simplon.orgamenu.models.PreferenceAliment;
import fr.simplon.orgamenu.models.User;
import fr.simplon.orgamenu.repository.AllergeneRepository;
import fr.simplon.orgamenu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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


    public List<Allergene> updateByUser(List<Allergene> allergenes) throws Exception {
        List<Allergene>Empty = new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            user.get().setAllergenes(Empty);
            user.get().setAllergenes(allergenes);
            userRepository.save( user.get());
            return user.get().getAllergenes();
        }throw new Exception();
    }
}
