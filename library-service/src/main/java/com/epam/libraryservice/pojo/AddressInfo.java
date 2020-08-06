package com.epam.libraryservice.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddressInfo {
    @Getter(onMethod_ = {@JsonProperty("id")})
    @Setter(onMethod_ = {@JsonProperty("id")})
    private long id;

    @Getter(onMethod_ = {@JsonProperty("line1")})
    @Setter(onMethod_ = {@JsonProperty("line1")})
    private String line1;

    @Getter(onMethod_ = {@JsonProperty("line2")})
    @Setter(onMethod_ = {@JsonProperty("line2")})
    private String line2;

    @Getter(onMethod_ = {@JsonProperty("city")})
    @Setter(onMethod_ = {@JsonProperty("city")})
    private String city;

    @Getter(onMethod_ = {@JsonProperty("state")})
    @Setter(onMethod_ = {@JsonProperty("state")})
    private String state;

    @Getter(onMethod_ = {@JsonProperty("country")})
    @Setter(onMethod_ = {@JsonProperty("country")})
    private String country;

    @Getter(onMethod_ = {@JsonProperty("pincode")})
    @Setter(onMethod_ = {@JsonProperty("pincode")})
    private long pincode;
}
