package com.epam.book_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;
    private float price;
    private String genre;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String name, float price, String genre) {
        this.name = name;
        this.price = price;
        this.genre = genre;
    }
}
