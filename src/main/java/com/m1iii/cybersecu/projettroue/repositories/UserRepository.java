package com.m1iii.cybersecu.projettroue.repositories;

import com.m1iii.cybersecu.projettroue.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Interface utilisée par l'ORM JPA pour générer les requêtes SQL pour la table User
 */
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    void deleteUserById(Long id);
    Optional<User> findUserByUsername(String username);
}