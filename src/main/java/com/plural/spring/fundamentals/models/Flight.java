package com.plural.spring.fundamentals.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Flight {
    private String id;
    private String company;
    private List<Passenger> passengers;

    public void print() {
        for (Passenger passenger : passengers) {
            System.out.println(passenger);
        }
    }
}
