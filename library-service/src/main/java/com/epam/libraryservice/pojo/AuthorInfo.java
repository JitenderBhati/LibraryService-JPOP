package com.epam.libraryservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AuthorInfo {
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    private long id;

    @Getter(onMethod_ = {@JsonProperty("name")})
    @Setter(onMethod_ = {@JsonProperty("name")})
    private String name;
}
