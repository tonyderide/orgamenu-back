package fr.simplon.orgamenu.controllers;

import fr.simplon.orgamenu.exceptions.EtapeNotFoundExceptions;
import fr.simplon.orgamenu.models.Etapes;
import fr.simplon.orgamenu.repository.EtapesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/etapes")
@RequiredArgsConstructor
public class EtapesController {

    EtapesRepository etapesRepository;


    @GetMapping("/{id}")
    public Etapes getEtapes(@PathVariable Long id) throws EtapeNotFoundExceptions {
        Optional<Etapes> etapes = etapesRepository.findById(id);
        if (etapes.isPresent()) {
            return etapes.get();
        }
        throw new EtapeNotFoundExceptions();
    }


}
