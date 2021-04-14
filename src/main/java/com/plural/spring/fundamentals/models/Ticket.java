package com.plural.spring.fundamentals.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ticket {
    private String number;
    private Passenger passenger;
}
