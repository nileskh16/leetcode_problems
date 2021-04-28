package com.plural.spring.fundamentals.listeners;

import com.plural.spring.fundamentals.domain.Airport;
import com.plural.spring.fundamentals.domain.FlightInformation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

@RequiredArgsConstructor
public class FlightEntityListener extends AbstractMongoEventListener<Object> {

    private final MongoTemplate mongoTemplate;

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Object> event) {
        Object source = event.getSource();

        if (source instanceof FlightInformation) {
            FlightInformation flightInformation = (FlightInformation) source;
            if (flightInformation.getDeparture() != null) {
                Airport airport = flightInformation.getDeparture();
                mongoTemplate.save(airport);
            }
            if (flightInformation.getDestination() != null) {
                Airport airport = flightInformation.getDestination();
                mongoTemplate.save(airport);
            }
        }
    }
}
