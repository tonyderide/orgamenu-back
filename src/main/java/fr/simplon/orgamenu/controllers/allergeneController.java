package fr.simplon.orgamenu.controllers;

import fr.simplon.orgamenu.models.Allergene;
import fr.simplon.orgamenu.services.AllergeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/allergenes")
public class allergeneController {

    @Autowired
    AllergeneService allergeneService;

    @GetMapping("/")
    public List<Allergene> findAllergeneUser() throws Exception {
        return allergeneService.findAllergeneUser();
    }
}
