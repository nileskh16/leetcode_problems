package com.plural.spring.fundamentals.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft {
    private String model;
    private int nbSeats;
}
