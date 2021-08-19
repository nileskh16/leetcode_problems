package com.plural.spring.fundamentals.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Embeddable
@Setter
@Getter
public class AppAddress {

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Column(name = "STATE_NAME")
    private String stateName;

    @Column(name = "ZIP_CODE")
    private String zipCode;
}
