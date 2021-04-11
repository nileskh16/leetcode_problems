package com.plural.spring.fundamentals.config;

import com.plural.spring.fundamentals.models.Speaker;
import com.plural.spring.fundamentals.repository.HibernateRepositoryImpl;
import com.plural.spring.fundamentals.repository.SpeakerRepository;
import com.plural.spring.fundamentals.services.SpeakerService;
import com.plural.spring.fundamentals.services.SpeakerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean(name = "speakerRepository")
    public SpeakerRepository<Speaker> getSpeakerRepository() {
        return new HibernateRepositoryImpl();
    }

    @Bean(name = "speakerService")
    public SpeakerService<Speaker> getSpeakerService() {
        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
        speakerService.setSpeakerRepository(getSpeakerRepository());
        return speakerService;
    }
}
