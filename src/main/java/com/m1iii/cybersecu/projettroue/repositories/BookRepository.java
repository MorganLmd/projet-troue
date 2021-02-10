package com.m1iii.cybersecu.projettroue.repositories;

import com.m1iii.cybersecu.projettroue.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Interface utilisée par l'ORM JPA pour générer les requêtes SQL pour la table Book
 */
public interface BookRepository extends CrudRepository<Book,Long> {
}
