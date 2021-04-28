package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.domain.Airport;
import com.plural.spring.fundamentals.domain.FlightInformation;
import com.plural.spring.fundamentals.domain.FlightType;
import com.plural.spring.fundamentals.repositories.AirportRepository;
import com.plural.spring.fundamentals.repositories.FlightInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Order(2)
@RequiredArgsConstructor
public class QueryRunner implements CommandLineRunner {

    private final FlightInformationRepository repository;
    private final AirportRepository airportRepository;

    @Override
    public void run(String... args) throws Exception {
        printAllAirports();
        printAllFlights();
    }

    public void setFlightsFromRomeDelayed() {
        List<FlightInformation> romeFlights = repository.findByDepartureCityLikeOrderByDurationMin("Rome");
        for (FlightInformation flight : romeFlights) {
            flight.setDelayed(true);
        }
        repository.saveAll(romeFlights);
    }

    public void removeInternalFLights() {
        List<FlightInformation> internalFlights = repository.findByType(FlightType.INTERNAL);
        repository.deleteAll(internalFlights);
    }

    public void printAllFlights() {
        List<FlightInformation> allFlights = repository.findAll(Sort.by(Sort.Direction.DESC, "durationMin"));
        allFlights.forEach(System.out::println);
    }

    public void printAllAirports() {
        List<Airport> airports = airportRepository.findAll();
        airports.forEach(System.out::println);
    }
}
