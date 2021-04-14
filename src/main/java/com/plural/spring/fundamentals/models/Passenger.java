package com.plural.spring.fundamentals.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Passenger {

    private String name;
    private String country;

    @Override
    public String toString() {
        return "Passenger " + name + " from " + country;
    }
}
