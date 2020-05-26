package fr.simplon.orgamenu.services;

import fr.simplon.orgamenu.models.*;
import fr.simplon.orgamenu.repository.CalendrierRecetteRepository;
import fr.simplon.orgamenu.repository.PreferenceRepository;
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
    @Autowired
    private AllergeneService allergeneService;
    @Autowired
    private PreferenceService preferenceService;

    public List<Recette> findAll() throws Exception {
        List<Recette> recettes = recetteRepository.findAll();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return moinsPreference(moinsAllergene(recettes));
        } else return recettes;
    }

    public Recette save(Recette recette) {
        return recetteRepository.save(recette);
    }

    public Optional<Recette> findById(int id) {
        System.out.println(id);
        return recetteRepository.findById(id);
    }

    public void deleteById(int id) {
        recetteRepository.deleteById(id);
    }


    public List<Recette> findAllByDateUser() throws Exception {
        List<Recette> recettesResult = new ArrayList<>();
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> user = userRepository.findByUsername(username);
        System.out.println("-------------" + username + "------------");
        if (user.isPresent()) {
            Set<CalendrierRecette> calendrierRecettes = calendrierRecetteRepository.findDateByIdUser(user.get().getId());
            for (CalendrierRecette i : calendrierRecettes) {
                System.out.println("=======>calendrierRecettes:" + i.getDate());
                recettesResult.addAll(recetteRepository.findRecetteByCalendriers(i));
            }
            return moinsAllergene(recettesResult);
        } else throw new Exception();

    }


    //soustrait les recettes avec allergenes
    public List<Recette> moinsAllergene(List<Recette> recettes) throws Exception {
        List<Recette> recettesRejected = new ArrayList<>();
        List<Allergene> allergeneUsers = allergeneService.findAllergeneUser();
        for (Allergene allergene : allergeneUsers) {
            for (Recette recette: recettes) {
                for (Ingredient ingredient : recette.getIngredients()) {
                    //si allergeneUser n'est pas un allergene de la recette
                    if ((ingredient.getAllergene()!=allergene.getId())) {
                        //je l'ajoute a la recette final j'ai la liste des recettes non voulu
                        if(!recettesRejected.contains(recette)){
                            recettesRejected.add(recette);
                        }
                    }
                }
            }
        }
        recettes.removeAll(recettesRejected);
        return recettes;
    }
    //soustrait les recettes sans preferences
    public List<Recette> moinsPreference(List<Recette> recettes) throws Exception {
        List<PreferenceAliment>prefUser=preferenceService.findAllUser();
        Set<Recette>recetteSelected=new HashSet<>();
        List<Recette> recettesFinal= new ArrayList<>();
        for (Recette recette: recettes) {
            List<Ingredient>ingredients=recette.getIngredients();
            for (Ingredient ingredient:ingredients) {
                for (PreferenceAliment pref:prefUser) {
                    //si le type de l'ingredient different de la pref alim
                    if (ingredient.getType() == pref.getIdPreferenceAliment()) {
                        recetteSelected.add(recette);
                        System.out.println("Moins preference=================>"+recette.getName());
                    }
                }
            }
        }
        recettesFinal.addAll(recetteSelected);
        return recettesFinal;
//        recettes.removeAll(recetteSelected);
//        return recettes;
    }

}
