package com.epam.book_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class BookDto {
    @NotBlank(message = "Name Required")
    @JsonProperty("name")
    private String name;

    @Min(value = 0, message = "Price Should be greater than 0")
    @JsonProperty("price")
    private float price;


    @NotEmpty(message = "Genre Required")
    @JsonProperty("genre")
    private String genre;

    @NotNull(message = "Author Required")
    @JsonProperty("author")
    private AuthorDto author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }
}
