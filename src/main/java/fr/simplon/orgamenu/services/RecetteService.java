package fr.simplon.orgamenu.services;

import fr.simplon.orgamenu.models.CalendrierRecette;
import fr.simplon.orgamenu.models.Recette;
import fr.simplon.orgamenu.models.User;
import fr.simplon.orgamenu.repository.CalendrierRecetteRepository;
import fr.simplon.orgamenu.repository.RecetteRepository;
import fr.simplon.orgamenu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecetteService {

        @Autowired
        private RecetteRepository recetteRepository;

        @Autowired
        private UserRepository userRepository;

        @Autowired
        private CalendrierRecetteRepository calendrierRecetteRepository;

        public List<Recette> findAll() { return recetteRepository.findAll();}

        public Recette save(Recette recette) { return recetteRepository.save(recette);}

        public Optional<Recette> findById(int id) { return recetteRepository.findById(id);}

        public void deleteById(int id) { recetteRepository.deleteById(id); }


        public List<Recette> findAllByUser() throws Exception {
                List<Recette> recetteResult = new ArrayList<>();
                String username = SecurityContextHolder.getContext().getAuthentication().getName();
                Optional<User> user = userRepository.findByUsername(username);
                System.out.println("-------------"+username+"------------");
                if (user.isPresent()) {
                        Set<CalendrierRecette> calendrierRecettes = calendrierRecetteRepository.findDateByIdUser(user.get().getId());
                        for (CalendrierRecette i:calendrierRecettes) {
                                System.out.println("=======>calendrierRecettes:"+i.getDate());
                                recetteResult.addAll(recetteRepository.findRecetteByCalendriers(i));
                        }
                        return recetteResult;
                        }else throw new Exception();

        }



}

