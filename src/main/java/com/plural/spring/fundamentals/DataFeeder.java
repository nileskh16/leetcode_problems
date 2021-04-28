package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.domain.Aircraft;
import com.plural.spring.fundamentals.domain.FlightInformation;
import com.plural.spring.fundamentals.domain.FlightType;
import com.plural.spring.fundamentals.repositories.FlightInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
@Order(1)
@RequiredArgsConstructor
public class DataFeeder implements CommandLineRunner {

//    private final MongoTemplate mongoTemplate;
    private final FlightInformationRepository repository;

    @Override
    public void run(String... args) throws Exception {
        remove();
        seed();
    }

    private void seed() {
        FlightInformation flightOne = new FlightInformation();
        flightOne.setDepartureCity("Rome");
        flightOne.setDestinationCity("Paris");
        flightOne.setDelayed(false);
        flightOne.setDurationMin(80);
        flightOne.setDepartureDate(LocalDate.of(2021, 4, 27));
        flightOne.setType(FlightType.INTERNATIONAL);
        flightOne.setAircraft(new Aircraft("AB1234", 450));

        FlightInformation flightTwo = new FlightInformation();
        flightTwo.setDepartureCity("New York");
        flightTwo.setDestinationCity("Copenhagen");
        flightTwo.setDurationMin(360);
        flightTwo.setDelayed(false);
        flightTwo.setDepartureDate(LocalDate.of(2021, 4, 29));
        flightTwo.setType(FlightType.INTERNATIONAL);
        flightTwo.setAircraft(new Aircraft("URC1234", 780));

        FlightInformation flightThree = new FlightInformation();
        flightThree.setDepartureCity("Barcelona");
        flightThree.setDestinationCity("Madrid");
        flightThree.setDurationMin(45);
        flightThree.setDepartureDate(LocalDate.of(2021, 4, 23));
        flightThree.setDelayed(false);
        flightThree.setType(FlightType.INTERNAL);
        flightThree.setAircraft(new Aircraft("SP123", 200));

        List<FlightInformation> allFlights = Arrays.asList(flightOne, flightTwo, flightThree);
        repository.insert(allFlights);
//        mongoTemplate.insertAll(allFlights);
    }

    public void remove() {
//        mongoTemplate.findAllAndRemove(new Query(), FlightInformation.class);
        repository.deleteAll();
    }
}
