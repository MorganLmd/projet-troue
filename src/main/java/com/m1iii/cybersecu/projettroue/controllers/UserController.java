package com.m1iii.cybersecu.projettroue.controllers;

import com.m1iii.cybersecu.projettroue.model.User;
import com.m1iii.cybersecu.projettroue.repositories.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Endpoint de l'application pour accéder aux traitements qui concernent un utilisateur
 * adresse de base du endpoint http://localhost:<port>/api/users
 * Les client n'ont pas accès à ce endpoint
 * seulement les admins
 */
@RestController
@Transactional
@RequestMapping("/management/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @GetMapping(path = "/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Optional<User> findById(@PathVariable("userId") Long userId) {
        return this.userRepository.findById(userId);
    }

    @GetMapping(path = "/email/{userEmail}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public Optional<User> findByEmail(@PathVariable("userEmail") String userEmail) {
        return this.userRepository.findUserByEmail(userEmail);
    }

    @PostMapping("/save")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public User save(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public void delete(@PathVariable("userId") Long userId) {
        this.userRepository.deleteUserById(userId);
    }

    @PutMapping("/update")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public User update(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
