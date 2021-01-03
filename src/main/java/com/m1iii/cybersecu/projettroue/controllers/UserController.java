package com.m1iii.cybersecu.projettroue.controllers;

import com.m1iii.cybersecu.projettroue.model.User;
import com.m1iii.cybersecu.projettroue.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

@RestController
@Transactional
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<User> findAll() {
        return this.userRepository.findAll();
    }

    @GetMapping(path = "/{userId}")
    public Optional<User> findById(@PathVariable("userId") Long userId) {
        return this.userRepository.findById(userId);
    }

    @GetMapping(path = "/email/{userEmail}")
    public Optional<User> findByEmail(@PathVariable("userEmail") String userEmail) {
        return this.userRepository.findUserByEmail(userEmail);
    }

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return this.userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") Long userId) {
        this.userRepository.deleteUserById(userId);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
