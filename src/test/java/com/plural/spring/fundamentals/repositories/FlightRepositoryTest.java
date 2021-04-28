package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.config.TestConfig;
import com.plural.spring.fundamentals.domain.Aircraft;
import com.plural.spring.fundamentals.domain.Airport;
import com.plural.spring.fundamentals.domain.FlightInformation;
import com.plural.spring.fundamentals.domain.FlightType;
import com.plural.spring.fundamentals.listeners.GenericEventListener;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@DataMongoTest
@ExtendWith(SpringExtension.class)
@Import(TestConfig.class)
@Category("integration")
class FlightRepositoryTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private FlightInformationRepository flightRepository;

    @Autowired
    private AirportRepository airportRepository;

    @BeforeEach
    public void feedData() {
        insertDataIntoDB();
    }

    @AfterEach
    public void deleteData() {
        mongoTemplate.dropCollection(FlightInformation.class);
        mongoTemplate.dropCollection(Airport.class);
    }

    @Test
    void testFlightFindAll() {
        List<FlightInformation> flightsFromRome = flightRepository.findByDepartureCityLikeOrderByDurationMin("Rome");
        Assertions.assertEquals(1, flightsFromRome.size());
        Assertions.assertEquals(80, flightsFromRome.get(0).getDurationMin());
        Assertions.assertEquals(4556678, flightsFromRome.get(0).getDeparture().getPassengersServed());
    }

    @Test
    void testInternationFlights() {
        List<FlightInformation> internationalFlights = flightRepository.findByType(FlightType.INTERNATIONAL);
        Assertions.assertEquals(3, internationalFlights.size());
    }

    @Test
    void testGenericListener() {
        List<Airport> allAirports = airportRepository.findAll();
        Assertions.assertEquals(3, allAirports.size());
    }

    private void insertDataIntoDB() {
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

        List<FlightInformation> flights = Arrays.asList(flightOne, flightTwo, flightThree);
        mongoTemplate.insertAll(flights);
    }
}
