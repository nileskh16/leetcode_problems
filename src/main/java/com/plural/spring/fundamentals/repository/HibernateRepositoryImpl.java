package com.plural.spring.fundamentals.repository;

import com.plural.spring.fundamentals.models.Speaker;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope(scopeName = "singleton")
public class HibernateRepositoryImpl implements SpeakerRepository<Speaker> {

    @Override
    public List<Speaker> findAll() {
        List<Speaker> allSpeakers = new ArrayList<>();
        Speaker speaker = new Speaker();
        speaker.setFirstName("Mark");
        speaker.setLastName("Byson");
        allSpeakers.add(speaker);
        return allSpeakers;
    }
}
