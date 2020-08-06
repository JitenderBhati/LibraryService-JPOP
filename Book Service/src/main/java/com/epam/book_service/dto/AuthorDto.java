package com.epam.book_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorDto {
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
