package com.epam.libraryservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
public class LibraryInfo {
    @Getter(onMethod_ ={@JsonProperty("id")})
    @Setter(onMethod_ ={@JsonProperty("id")})
    private int id;

    @Getter(onMethod_ ={@JsonProperty("user")})
    @Setter(onMethod_ ={@JsonProperty("user")})
    private UserInfo userInfo;

    @Getter(onMethod_ ={@JsonProperty("book")})
    @Setter(onMethod_ ={@JsonProperty("book")})
    private BookInfo book;

    @Getter(onMethod_ ={@JsonProperty("issueDate")})
    @Setter(onMethod_ ={@JsonProperty("issueDate")})
    private LocalDate issueDate;

    @Getter(onMethod_ ={@JsonProperty("returnDate")})
    @Setter(onMethod_ ={@JsonProperty("returnDate")})
    private LocalDate returnDate;
}
