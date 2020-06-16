package fr.simplon.orgamenu.controllers;

import fr.simplon.orgamenu.models.Allergene;
import fr.simplon.orgamenu.models.PreferenceAliment;
import fr.simplon.orgamenu.services.AllergeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/allergenes")
public class allergeneController {

    @Autowired
    AllergeneService allergeneService;

    /**
     * Get List of allergene by usercontextsecurity
     * @return List<Allergene>
     * @throws Exception
     */
    @GetMapping("/")
    public List<Allergene> findAllergeneUser() throws Exception {
        return allergeneService.findAllergeneUser();
    }

    /**
     * create a list of allergene
     * @param allergenes List<Allergene>
     * @return List<Allergene>
     * @throws Exception if there's no List<Allergene> in the body
     */
    @PostMapping("/")
    public List<Allergene> create(@RequestBody List<Allergene> allergenes) throws Exception {
        return allergeneService.updateByUser(allergenes);
    }
}
