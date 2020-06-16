package fr.simplon.orgamenu.controllers;


import fr.simplon.orgamenu.exceptions.UserNotFoundExceptions;
import fr.simplon.orgamenu.models.User;
import fr.simplon.orgamenu.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * Get user By username as role user or admin
     * @param username
     * @return an User
     * @throws UserNotFoundExceptions
     */
    @GetMapping("username/{username}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Optional<User> getByUsername(@PathVariable String username) throws UserNotFoundExceptions {
        Optional<User> user = userService.findByUsername(username);
        if (user.isPresent()) {
            return user;
        }
        throw new UserNotFoundExceptions();
    }

    /**
     * Get all users as an admin
     * @return a User
     */
    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAll() {
        return userService.findAll();
    }

    /**
     * Get user by id as role user or admin
     * @param id
     * @return a User
     * @throws UserNotFoundExceptions
     */
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Optional<User> getUserById(@PathVariable int id) throws UserNotFoundExceptions {
        Optional<User> user = userService.findById(id);
        if (user.isPresent()) {
            System.out.println(user);
            return user;
        }
        throw new UserNotFoundExceptions();
    }
}

