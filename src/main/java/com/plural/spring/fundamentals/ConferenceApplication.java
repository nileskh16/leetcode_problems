package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.config.AppConfig;
import com.plural.spring.fundamentals.models.Speaker;
import com.plural.spring.fundamentals.services.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConferenceApplication {

    public static void main(String[] args) {
        runConferenceApplication();
    }

    private static void runConferenceApplication() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpeakerService<Speaker> speakerService = context.getBean("speakerService", SpeakerService.class);
        System.out.println(speakerService.findAllEntities().get(0).getFirstName());
    }
}
