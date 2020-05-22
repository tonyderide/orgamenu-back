package fr.simplon.orgamenu.services;

import fr.simplon.orgamenu.models.PreferenceAliment;
import fr.simplon.orgamenu.models.Recette;
import fr.simplon.orgamenu.models.User;
import fr.simplon.orgamenu.repository.PreferenceRepository;
import fr.simplon.orgamenu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PreferenceService {

    @Autowired
    PreferenceRepository preferenceRepository;
    @Autowired
    UserRepository userRepository;


    public List<PreferenceAliment>findAllUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            System.out.println("==============================>"+user.get().getPreferenceAliments());
            return user.get().getPreferenceAliments();
        } else return preferenceRepository.findAll();
    }

    public List<PreferenceAliment>findAll()  {
        return preferenceRepository.findAll();
    }

    public List<PreferenceAliment> updateByUser(List<PreferenceAliment> preference) throws Exception {
        List<PreferenceAliment>Empty=new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            user.get().setPreferenceAliments(Empty);
            user.get().setPreferenceAliments(preference);
            userRepository.save( user.get());
            return user.get().getPreferenceAliments();
        }throw new Exception();

    }

}


