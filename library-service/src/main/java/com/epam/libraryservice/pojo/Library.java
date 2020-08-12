package com.epam.libraryservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    private int id;

    @Column(nullable = false)
    @Getter(onMethod_ = {@JsonProperty("user")})
    @Setter(onMethod_ = {@JsonProperty("user")})
    private int user;

    @Column(nullable = false)
    @Getter(onMethod_ = {@JsonProperty("book")})
    @Setter(onMethod_ = {@JsonProperty("book")})
    private int book;

    @Column(nullable = false)
    @Getter(onMethod_ = {@JsonProperty("issueDate")})
    @Setter(onMethod_ = {@JsonProperty("issueDate")})
    private LocalDate issuedate;

    @Getter(onMethod_ = {@JsonProperty("returnDate")})
    @Setter(onMethod_ = {@JsonProperty("returnDate")})
    private LocalDate returndate;

    @Column(nullable = false)
    @Getter(onMethod_ = {@JsonProperty("issuedBy")})
    @Setter(onMethod_ = {@JsonProperty("issuedBy")})
    private int issuedby;
}
