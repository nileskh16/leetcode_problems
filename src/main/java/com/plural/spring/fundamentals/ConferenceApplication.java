package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.models.Speaker;
import com.plural.spring.fundamentals.services.SpeakerService;
import com.plural.spring.fundamentals.services.SpeakerServiceImpl;

public class ConferenceApplication {

    public static void main(String[] args) {
        runConferenceApplication();
    }

    private static void runConferenceApplication() {
        SpeakerService<Speaker> speakerService = new SpeakerServiceImpl();
        System.out.println(speakerService.findAllEntities().get(0).getFirstName());
    }
}
