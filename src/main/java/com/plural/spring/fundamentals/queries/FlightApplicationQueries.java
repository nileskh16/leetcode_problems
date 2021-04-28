package com.plural.spring.fundamentals.queries;

import com.plural.spring.fundamentals.domain.FlightInformation;
import com.plural.spring.fundamentals.domain.FlightType;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightApplicationQueries {

    private final MongoTemplate mongoTemplate;

    public List<FlightInformation> findAll(String field, int pageNb, int pageSize) {
        Query query = new Query()
                .with(Sort.by(Sort.Direction.ASC, field))
                .with(PageRequest.of(pageNb, pageSize));
        return mongoTemplate.find(query, FlightInformation.class);
    }

    public FlightInformation findById(String id) {
        return mongoTemplate.findById(id, FlightInformation.class);
    }

    public Long countInternationFlights() {
        Query query = Query.query(Criteria.where("type").is(FlightType.INTERNATIONAL));
        return mongoTemplate.count(query, FlightInformation.class);
    }

    public List<FlightInformation> findByDepartureCity(String value) {
        Query query = new Query(Criteria.where("departure").is(value));
        return mongoTemplate.find(query, FlightInformation.class);
    }

    public List<FlightInformation> findByDuration(Integer min, Integer max) {
        Query query = new Query(Criteria.where("durationMin").gte(min).lte(max))
                .with(Sort.by(Sort.Direction.DESC, "durationMin"));
        return mongoTemplate.find(query, FlightInformation.class);
    }

    public List<FlightInformation> findDelayedFlights(String value) {
        Query query = new Query(new Criteria().
                andOperator(Criteria.where("departure").is(value),
                        Criteria.where("isDelayed").is(true)));
        return mongoTemplate.find(query, FlightInformation.class);
    }
}