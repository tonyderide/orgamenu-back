package fr.simplon.orgamenu.controllers;


import com.google.common.base.Preconditions;
import fr.simplon.orgamenu.models.CalendrierRecette;
import fr.simplon.orgamenu.services.CalendrierRecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/calendrierrecettes")
public class CalendrierRecetteController {

    @Autowired
    CalendrierRecetteService calendrierRecetteService;

    /**
     * Get a list of all CalendrierRecette
     * @return List<CalendrierRecette>
     */
    @GetMapping("/")
    public List<CalendrierRecette> findAll() {
        return calendrierRecetteService.findAll();
    }

    /**
     * Get a CalendrierRecette by id
     * @param id
     * @return Optional<CalendrierRecette>
     */
    @GetMapping("/{id}")
    public Optional<CalendrierRecette> findById(@PathVariable("id") int id) {
        Preconditions.checkNotNull(calendrierRecetteService.findById(id));
        return calendrierRecetteService.findById(id);
    }

    /**
     * find CalendrierRecette by user
     * @return Set<CalendrierRecette>
     * @throws Exception
     */
    @GetMapping("/users/")
    public Set<CalendrierRecette> findByUser() throws Exception {
        return calendrierRecetteService.findByUser();
    }

    /**
     * Get CalendrierRecette by date
     * @param  date
     * @return Set<CalendrierRecette>
     * @throws Exception
     */
    @PostMapping("date/")
    public Set<CalendrierRecette> findByDate(@RequestBody CalendrierRecette date) throws Exception {
        Preconditions.checkNotNull(date);
        return calendrierRecetteService.findByDateAndUser(date);
    }

    /**
     * Create a CalendrierRecette associated with a recette
     * @param idRecette
     * @param resource
     * @return CalendrierRecette
     * @throws Exception
     */
    @PostMapping(value = "/{idRecette}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CalendrierRecette create(@PathVariable("idRecette") int idRecette, @RequestBody CalendrierRecette resource) throws Exception {
        Preconditions.checkNotNull(resource,"we need a CalendrierRecette in the body");
        return calendrierRecetteService.create(idRecette, resource);
    }

    /**
     * Update a CalendrierRecette and is Recette
     * @param id id of Recette
     * @param resource CalendrierRecette
     * @return
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<CalendrierRecette> update(@RequestParam int id, @RequestBody CalendrierRecette resource) {
        Preconditions.checkNotNull(resource,"we need a CalendrierRecette in the body");
        calendrierRecetteService.update(id, resource);
        return calendrierRecetteService.findById(id);
    }

    /**
     * Delete CalendrierRecette
     * @param date of type CalendrierRecette
     * @throws Exception
     */
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody CalendrierRecette date) throws Exception {
        calendrierRecetteService.deleteByDate(date);
    }

    /**
     * Delete all CalendrierRecette where date < today date
     */
    @DeleteMapping("/init")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInit() {
        calendrierRecetteService.deleteBeforeToday();
    }


}



