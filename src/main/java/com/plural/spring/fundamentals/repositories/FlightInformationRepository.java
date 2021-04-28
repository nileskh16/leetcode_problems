package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.domain.FlightInformation;
import com.plural.spring.fundamentals.domain.FlightType;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightInformationRepository extends MongoRepository<FlightInformation, String> {

    List<FlightInformation> findByDepartureCityLikeOrderByDurationMin(String cityName);
    List<FlightInformation> findByType(FlightType type);
}
