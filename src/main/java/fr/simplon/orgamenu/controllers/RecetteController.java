package fr.simplon.orgamenu.controllers;


import fr.simplon.orgamenu.exceptions.RecetteNotFoundExceptions;
import fr.simplon.orgamenu.models.Recette;
import fr.simplon.orgamenu.services.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/recettes")
public class RecetteController {

    @Autowired
    RecetteService recetteService;


    /**
     * Récupere une liste de recette
     *
     * @return une liste d'Objet recette
     */
    @GetMapping("/")
    public ResponseEntity<List<Recette>> getAll() {
        try {
            return ResponseEntity.ok(recetteService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/datesuser")
    public ResponseEntity<List<Recette>> getAllByDateUser() {
        try {
            return ResponseEntity.ok(recetteService.findAllByDateUser());
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    /**
     * Récupere une recette
     *
     * @param id Id d'une recette
     * @return un Objet recette
     */
    @GetMapping("/{id}")
    public Recette getRecette(@PathVariable int id) throws RecetteNotFoundExceptions {
        Optional<Recette> recette = recetteService.findById(id);
        if (recette.isPresent()) {
            return recette.get();
        }
        throw new RecetteNotFoundExceptions();
    }

    /**
     * Crée une recette
     *
     * @param recette un objet Recette
     * @return Sauvegarde la recette en base
     */
    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Recette create(@RequestBody Recette recette) {
        return recetteService.save(recette);
    }

    /**
     * @param id Id d'une recette
     * @return Supprime une recette
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity delete(@PathVariable int id) {
        Optional<Recette> recette = (recetteService.findById(id));
        if (!recette.isPresent()) {
            ResponseEntity.badRequest().body("la recette n'existe pas!");
        }
        recetteService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
