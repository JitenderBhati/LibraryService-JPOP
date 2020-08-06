package com.epam.libraryservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class UserInfo {
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    private long id;

    @Getter(onMethod_ = {@JsonProperty("firstname")})
    @Setter(onMethod_ = {@JsonProperty("firstname")})
    private String firstname;

    @Getter(onMethod_ = {@JsonProperty("lastname")})
    @Setter(onMethod_ = {@JsonProperty("lastname")})
    private String lastname;

    @Getter(onMethod_ = {@JsonProperty("age")})
    @Setter(onMethod_ = {@JsonProperty("age")})
    private long age;

    @Getter(onMethod_ = {@JsonProperty("address")})
    @Setter(onMethod_ = {@JsonProperty("address")})
    private AddressInfo addressInfo;
}
