package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.domain.FlightInformation;
import com.plural.spring.fundamentals.domain.FlightType;
import com.plural.spring.fundamentals.repositories.FlightInformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Order(2)
@RequiredArgsConstructor
public class QueryRunner implements CommandLineRunner {

//    private final MongoTemplate mongoTemplate;
    private final FlightInformationRepository repository;

    @Override
    public void run(String... args) throws Exception {
        setFlightsFromRomeDelayed();
        removeInternalFLights();
        printAllFlights();
    }

    public void setFlightsFromRomeDelayed() {
//        Query query = new Query(Criteria.where("departure").is("Rome"));
//        Update updateStmt = Update.update("isDelayed", true);
//        mongoTemplate.updateMulti(query, updateStmt, FlightInformation.class);

        List<FlightInformation> romeFlights = repository.findByDepartureCityLikeOrderByDurationMin("Rome");
        for (FlightInformation flight : romeFlights) {
            flight.setDelayed(true);
        }
        repository.saveAll(romeFlights);
    }

    public void removeInternalFLights() {
//        Query query = new Query(Criteria.where("type").is(FlightType.INTERNAL));
//        mongoTemplate.findAllAndRemove(query, FlightInformation.class);
        List<FlightInformation> internalFlights = repository.findByType(FlightType.INTERNAL);
        repository.deleteAll(internalFlights);
    }

    public void printAllFlights() {
//        List<FlightInformation> allFlights = mongoTemplate.findAll(FlightInformation.class);
        List<FlightInformation> allFlights = repository.findAll(Sort.by(Sort.Direction.DESC, "durationMin"));
        allFlights.forEach(System.out::println);
    }
}
