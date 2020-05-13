//package fr.simplon.orgamenu.services;
//
//import fr.simplon.orgamenu.models.CalendrierRecette;
//import fr.simplon.orgamenu.models.Ingredient;
//import fr.simplon.orgamenu.models.Recette;
//import fr.simplon.orgamenu.models.User;
//import fr.simplon.orgamenu.repository.IngredientRepository;
//import fr.simplon.orgamenu.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class IngredientsService {
//
//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    IngredientRepository ingredientRepository;
//
//    @Autowired
//    CalendrierRecetteService calendrierRecetteService;
//
//    public Optional<Set<Ingredient>> findByUser(Set<CalendrierRecette> calendriers) throws Exception {
//        Set<Recette>recettes=new HashSet<>();
//        for ( CalendrierRecette calendrier : calendriers) {
//            calendrierRecetteService.findByDateAndUser(calendrier);
//            return ;
//        }throw new Exception();
//    }
//}
