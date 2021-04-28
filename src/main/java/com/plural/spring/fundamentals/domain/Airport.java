package com.plural.spring.fundamentals.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Airport {

    @Id
    private String id;
    private String name;
    private String city;
    private Integer passengersServed;

    public Airport(String name, String city, Integer passengersServed) {
        this.name = name;
        this.city = city;
        this.passengersServed = passengersServed;
    }
}
