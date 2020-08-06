package com.epam.libraryservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class BookInfo {
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    private long id;

    @Getter(onMethod_ = {@JsonProperty("name")})
    @Setter(onMethod_ = {@JsonProperty("name")})
    private String name;

    @Getter(onMethod_ = {@JsonProperty("price")})
    @Setter(onMethod_ = {@JsonProperty("price")})
    private double price;

    @Getter(onMethod_ = {@JsonProperty("genre")})
    @Setter(onMethod_ = {@JsonProperty("genre")})
    private String genre;

    @Getter(onMethod_ = {@JsonProperty("author")})
    @Setter(onMethod_ = {@JsonProperty("author")})
    private AuthorInfo author;
}
