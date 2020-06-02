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
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CalendrierRecetteService {

    @Autowired
    CalendrierRecetteRepository calendrierRecetteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RecetteRepository recetteRepository;

    public List<CalendrierRecette> findAll() {
        return calendrierRecetteRepository.findAll();
    }

    public Optional<CalendrierRecette> findById(int id) {
        return calendrierRecetteRepository.findById(id);
    }

    public Set<CalendrierRecette> findByUser() throws Exception {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            int id = user.get().getId();
            return calendrierRecetteRepository.findDateByIdUser(id);
        } else {
            throw new Exception();
        }
    }

    public CalendrierRecette create(int recetteId, CalendrierRecette calendrierRecette) throws Exception {
        //sauvegarde de la recette dans le calendrier courant
        Optional<Recette> recette = recetteRepository.findById(recetteId);
        Set<Recette> recettes = new HashSet<>();
        if (recette.isPresent()) {
            recettes.add(recette.get());
            calendrierRecette.setRecettes(recettes);
        }
        //sauvegarde de l'utilisateur dans le calendrier courant
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            calendrierRecette.setUser(user.get());
            //sauvegarde de la recette
            return calendrierRecetteRepository.save(calendrierRecette);
        }
        throw new Exception();

    }

    public void update(int idRecette, CalendrierRecette resource) {
          calendrierRecetteRepository.updateById(idRecette, resource.getDate());
    }

//    @Transactional
//    public void deleteByDate(CalendrierRecette calendrier) {
//        LocalDate date = calendrier.getDate();
//        calendrierRecetteRepository.deleteByDate(date);
//    }

    public Set<CalendrierRecette> findByDateAndUser(CalendrierRecette date) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return calendrierRecetteRepository.findByDatebyCurrentUser(date.getDate(), user.get());
        } else
            return calendrierRecetteRepository.findByDate(date.getDate());


    }

    public void deleteBeforeToday() {
        LocalDate date = LocalDate.now();
        calendrierRecetteRepository.deleteByDateBefore(date);
    }

    public void deleteByDate(CalendrierRecette calendrier) {
            calendrierRecetteRepository.deleteById(calendrier.getIdCalendrier());
    }
}
