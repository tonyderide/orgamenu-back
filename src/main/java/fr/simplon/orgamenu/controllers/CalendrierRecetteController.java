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


    @GetMapping("/")
    public List<CalendrierRecette> findAll() {
        return calendrierRecetteService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<CalendrierRecette> findById(@PathVariable("id") int id) {
        Preconditions.checkNotNull(calendrierRecetteService.findById(id));
        return calendrierRecetteService.findById(id);
    }

    @GetMapping("/users/")
    public Set<CalendrierRecette> findByUser() throws Exception {
        return calendrierRecetteService.findByUser();
    }

    @PostMapping("date/")
    public Set<CalendrierRecette> findByDate(@RequestBody CalendrierRecette date) throws Exception {
        Preconditions.checkNotNull(date);
        return calendrierRecetteService.findByDateAndUser(date);
    }

    @PostMapping(value = "/{idRecette}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CalendrierRecette create(@PathVariable("idRecette") int idRecette, @RequestBody CalendrierRecette resource) throws Exception {
        Preconditions.checkNotNull(resource);
        return calendrierRecetteService.create(idRecette, resource);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Optional<CalendrierRecette> update(@RequestParam int id, @RequestBody CalendrierRecette resource) {
        Preconditions.checkNotNull(resource);
        calendrierRecetteService.update(id, resource);
        return calendrierRecetteService.findById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody CalendrierRecette date) throws Exception {
        calendrierRecetteService.deleteByDate(date);
    }

    @DeleteMapping("/init")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInit() {
        calendrierRecetteService.deleteBeforeToday();
    }


}



