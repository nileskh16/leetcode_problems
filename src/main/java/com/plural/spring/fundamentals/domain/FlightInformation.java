package com.plural.spring.fundamentals.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Setter
@Document(collection = "flights")
@ToString
public class FlightInformation {

    @Id
    private String id;

    @DBRef(lazy = true)
    private Airport departure;

    @DBRef(lazy = true)
    private Airport destination;

    private FlightType type;
    private boolean isDelayed;
    private int durationMin;
    private LocalDate departureDate;

    @Transient
    private LocalDate createAt;
    private Aircraft aircraft;

    public FlightInformation() {
        this.createAt = LocalDate.now();
    }
}
