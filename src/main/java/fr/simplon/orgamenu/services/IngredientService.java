package fr.simplon.orgamenu.services;

import ch.qos.logback.core.util.COWArrayList;
import fr.simplon.orgamenu.models.CalendrierRecette;
import fr.simplon.orgamenu.models.Ingredient;
import fr.simplon.orgamenu.models.Recette;
import fr.simplon.orgamenu.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class IngredientService {

    @Autowired
    CalendrierRecetteService calendrierRecetteService;


    @Autowired
    IngredientRepository ingredientRepository;

//    public List<Ingredient> findAll() {
//        return ingredientRepository.findAll();
//    }
    public List<Ingredient> findAll() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return ingredientRepository.findAll();
    }

    public List<Ingredient>findAllByUser() throws Exception {
        Set<CalendrierRecette> dates;
        Set<Recette>recettes = new HashSet<>();
        List<Ingredient> ingredients = new ArrayList<>();
        List<Ingredient> finalIngredients = new ArrayList<>();
        //recupe la liste de date
        dates = calendrierRecetteService.findByUser();
        for (CalendrierRecette date: dates) {
            //rajoute les recettes correspondant au date
            recettes.addAll(date.getRecettes());
            for (Recette recette:recettes) {
                //rajoute les ingredients correspondant au recette
                ingredients.addAll(recette.getIngredients());
            }
        }
        Map<String, Ingredient> i = new HashMap<>();
        for (Ingredient ingredient : ingredients) {
            if (i.containsKey(ingredient.getNomIngredient())) {
                i.get(ingredient.getNomIngredient()).addQuantity(ingredient.getQuantity());
            }
            else {
                i.put(ingredient.getNomIngredient(), new Ingredient(ingredient));
            }
        }
        finalIngredients = new ArrayList<>(i.values());
        return finalIngredients;
    }
//    public List<Ingredient>findAllByUser() throws Exception {
//        Set<CalendrierRecette> dates;
//        Set<Recette>recettes = new HashSet<>();
//        List<Ingredient> ingredients = new ArrayList<>();
//        List<Ingredient> finalIngredients = new ArrayList<>();
//        //recupe la liste de date
//        dates = calendrierRecetteService.findByUser();
//        for (CalendrierRecette date: dates) {
//            //rajoute les recettes correspondant au date
//            recettes.addAll(date.getRecettes());
//            for (Recette recette:recettes) {
//                //rajoute les ingredients correspondant au recette
//                ingredients.addAll(recette.getIngredients());
//            }
//        }
//        Map<String, Ingredient> i = new HashMap<>();
//        for (Ingredient ingredient : ingredients) {
//            if (i.containsKey(ingredient.getNomIngredient())) {
//                i.get(ingredient.getNomIngredient()).addQuantity(ingredient.getQuantity());
//            }
//            else {
//                i.put(ingredient.getNomIngredient(), new Ingredient(ingredient));
//            }
//        }
//            finalIngredients = new ArrayList<>(i.values());
//        return finalIngredients;
//    }
}
