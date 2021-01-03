package com.m1iii.cybersecu.projettroue.controllers;

import com.m1iii.cybersecu.projettroue.model.Book;
import com.m1iii.cybersecu.projettroue.model.User;
import com.m1iii.cybersecu.projettroue.repositories.BookRepository;
import com.m1iii.cybersecu.projettroue.repositories.UserRepository;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.*;

/**
 * Endpoint de l'application pour accéder aux traitements qui concernent un livre
 * adresse de base du endpoint http://localhost:<port>/api/books
 */
@RestController
@Transactional
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookController(BookRepository bookRepository, UserRepository userRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public Iterable<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @GetMapping(path = "/{bookId}")
    public Optional<Book> findById(@PathVariable("bookId") Long bookId) {
        return this.bookRepository.findById(bookId);
    }

    @GetMapping(path = "/owner/{userId}")
    public Set<Book> findOwnedBooksByUserId(@PathVariable("userId") Long userId) {
        Optional<User> userOptional = this.userRepository.findById(userId);
        Set<Book> books = new HashSet<>();
        if (userOptional.isPresent()) {
            return userOptional.get().getBooksOwned();
        }
        return books;
    }

    @GetMapping(path = "/{bookId}/owners")
    public Set<User> findOwnersByBookId(@PathVariable("bookId") Long bookId) {
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        Set<User> owners = new HashSet<>();
        if (bookOptional.isPresent()) {
            return bookOptional.get().getOwners();
        }
        return owners;
    }

    @PutMapping(path = "/{bookId}/add")
    public void addNewOwnerToBook(@PathVariable("bookId") Long bookId, @RequestBody User user) {
        Optional<Book> bookOptional = this.bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            bookOptional.get().getOwners().add(user);
            this.bookRepository.save(bookOptional.get());
        }
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

    @PutMapping
    public Book update(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

    @DeleteMapping(path = "/{bookId}")
    public void deleteById(@PathVariable("bookId") Long bookId) {
        this.bookRepository.deleteById(bookId);
    }
}
