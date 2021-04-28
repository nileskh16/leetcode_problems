package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.domain.Airport;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirportRepository extends MongoRepository<Airport, String> {
}
