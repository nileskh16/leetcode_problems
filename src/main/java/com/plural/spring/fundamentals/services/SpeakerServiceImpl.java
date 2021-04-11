package com.plural.spring.fundamentals.services;

import com.plural.spring.fundamentals.models.Speaker;
import com.plural.spring.fundamentals.repository.HibernateRepositoryImpl;
import com.plural.spring.fundamentals.repository.SpeakerRepository;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService<Speaker> {

    private SpeakerRepository<Speaker> speakerRepository;

    public SpeakerServiceImpl() {
        speakerRepository = new HibernateRepositoryImpl();
    }

    @Override
    public List<Speaker> findAllEntities() {
        return speakerRepository.findAll();
    }
}
