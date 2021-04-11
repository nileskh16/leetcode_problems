package com.plural.spring.fundamentals.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.plural.spring.fundamentals")
public class AppConfig {

//    @Bean(name = "speakerRepository")
//    public SpeakerRepository<Speaker> getSpeakerRepository() {
//        return new HibernateRepositoryImpl();
//    }
//
//    @Bean(name = "speakerService")
//    public SpeakerService<Speaker> getSpeakerService() {
//        SpeakerServiceImpl speakerService = new SpeakerServiceImpl();
//        speakerService.setSpeakerRepository(getSpeakerRepository());
//        return speakerService;
//    }
}
