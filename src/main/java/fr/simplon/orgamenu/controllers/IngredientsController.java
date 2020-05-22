//package fr.simplon.orgamenu.controllers;
//
//import com.google.common.base.Preconditions;
//import fr.simplon.orgamenu.models.CalendrierRecette;
//import fr.simplon.orgamenu.models.Ingredient;
//import fr.simplon.orgamenu.services.IngredientsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//import java.util.Set;
//
//@CrossOrigin(origins = "*", maxAge = 3600)
//@RestController
//@RequestMapping("/api/ingredients")
//public class IngredientsController {
//
//    @Autowired
//    IngredientsService ingredientsService;
//
//    @GetMapping("/")
//    public Optional<Set<Ingredient>> findById(@RequestBody Set<CalendrierRecette> calendriers) throws Exception {
//        Preconditions.checkNotNull(ingredientsService.findByUser(calendriers));
//        return ingredientsService.findByUser(calendriers);
//    }
//
//}
