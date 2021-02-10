package com.m1iii.cybersecu.projettroue.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String title;
    private String author;
    private String publisher;

    @Lob
    private String description;

    private String bookFormat;

    @ManyToMany(mappedBy = "booksOwned")
    @JsonIgnore
    private Set<User> owners;
}
