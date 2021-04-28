package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.domain.Aircraft;
import com.plural.spring.fundamentals.domain.Airport;
import com.plural.spring.fundamentals.domain.FlightInformation;
import com.plural.spring.fundamentals.domain.FlightType;
import com.plural.spring.fundamentals.repositories.AirportRepository;
import com.plural.spring.fundamentals.repositories.FlightInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
@RequiredArgsConstructor
public class DataFeeder implements CommandLineRunner {

    private final FlightInformationRepository repository;
    private final AirportRepository airportRepository;

    @Override
    public void run(String... args) throws Exception {
        remove();
        seed();
    }

    private void seed() {

        Airport rome = new Airport("Leonardo Da Vinci", "Rome", 4556678);
        Airport paris = new Airport("Jeff Kendall", "Paris", 7890458);
        Airport newYork = new Airport("JFK", "New York", 99007656);


        FlightInformation flightOne = new FlightInformation();
        flightOne.setDeparture(rome);
        flightOne.setDestination(newYork);
        flightOne.setDelayed(false);
        flightOne.setDurationMin(80);
        flightOne.setDepartureDate(LocalDate.of(2021, 4, 27));
        flightOne.setType(FlightType.INTERNATIONAL);
        flightOne.setAircraft(new Aircraft("AB1234", 450));

        FlightInformation flightTwo = new FlightInformation();
        flightTwo.setDeparture(newYork);
        flightTwo.setDestination(paris);
        flightTwo.setDurationMin(360);
        flightTwo.setDelayed(false);
        flightTwo.setDepartureDate(LocalDate.of(2021, 4, 29));
        flightTwo.setType(FlightType.INTERNATIONAL);
        flightTwo.setAircraft(new Aircraft("URC1234", 780));

        FlightInformation flightThree = new FlightInformation();
        flightThree.setDeparture(paris);
        flightThree.setDestination(rome);
        flightThree.setDurationMin(45);
        flightThree.setDepartureDate(LocalDate.of(2021, 4, 23));
        flightThree.setDelayed(false);
        flightThree.setType(FlightType.INTERNATIONAL);
        flightThree.setAircraft(new Aircraft("SP123", 200));

        // Added mongoEventListener onBeforeConvert to save airports to the database
//        List<Airport> airports = Arrays.asList(rome, paris, newYork);
//        airportRepository.insert(airports);
        List<FlightInformation> allFlights = Arrays.asList(flightOne, flightTwo, flightThree);
        repository.insert(allFlights);
    }

    public void remove() {
        repository.deleteAll();
        airportRepository.deleteAll();
    }
}