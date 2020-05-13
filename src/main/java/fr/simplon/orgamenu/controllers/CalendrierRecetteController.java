package fr.simplon.orgamenu.controllers;


import com.google.common.base.Preconditions;
import fr.simplon.orgamenu.models.CalendrierRecette;
import fr.simplon.orgamenu.services.CalendrierRecetteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
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
        System.out.println(date.toString());
        Preconditions.checkNotNull(calendrierRecetteService.findByDateAndUser(date));
        return calendrierRecetteService.findByDateAndUser(date);
    }

    @PostMapping(value="/{idRecette}")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public CalendrierRecette create(@PathVariable("idRecette") Optional<Integer> idRecette, @RequestBody CalendrierRecette resource)throws Exception {
        if (idRecette.isPresent()) {
            Preconditions.checkNotNull(resource);
            return calendrierRecetteService.create(idRecette.get(), resource);
        }else{
            throw new Exception();
        }
    }

    @PutMapping(value = "/{idRecette}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("idRecette") int idRecette, @RequestBody CalendrierRecette resource) {
        Preconditions.checkNotNull(resource);
        Preconditions.checkNotNull(calendrierRecetteService.findById(resource.getIdCalendrier()));
        calendrierRecetteService.update(idRecette,resource);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody CalendrierRecette date) {
        calendrierRecetteService.deleteByDate(date);
    }

    @DeleteMapping("/init")
    @ResponseStatus(HttpStatus.OK)
    public void deleteInit() {
        calendrierRecetteService.deleteBeforeToday();
    }



}



