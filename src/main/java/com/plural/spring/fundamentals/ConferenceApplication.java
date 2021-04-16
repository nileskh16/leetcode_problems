package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.annotations.FieldSerializer;
import com.plural.spring.fundamentals.config.AppConfig;
import com.plural.spring.fundamentals.dao.PassengerDao;
import com.plural.spring.fundamentals.models.*;
import com.plural.spring.fundamentals.services.SpeakerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ConferenceApplication {

    public static void main(String[] args) {
        runAnnotationSerializer();
    }

    private static void runConferenceApplication() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        SpeakerService<Speaker> speakerService = context.getBean(SpeakerService.class);
        System.out.println(speakerService.findAllEntities().get(0).getFirstName());
    }

    private static void runSpelApplication() {
        SpelExpressionParser parser = new SpelExpressionParser();
        String value = (String) parser.parseExpression("'Hello World'").getValue();
        Integer len = (Integer) parser.parseRaw("'Hello World'.length()").getValue();
        EvaluationContext context = new StandardEvaluationContext();
        context.setVariable("country", "Hello USA");
        System.out.println(parser.parseExpression("#country.substring(6)").getValue(context));
        parser.parseExpression("#country").setValue(context, "Hello UK");
        System.out.println(parser.parseExpression("#country.substring(6)").getValue(context));
        System.out.println(value);
        System.out.println(len);
    }

    private static void runPassengerApplication() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
        System.out.println(passengerDao.getPassenger(1));
        context.close();
    }

    private static void runFlightApplication() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("flightManagementContext.xml");
        Passenger jim = context.getBean("jim", Passenger.class);
        Passenger jerry = context.getBean("jerry", Passenger.class);
        Passenger tom = context.getBean("Tom", Passenger.class);

        Flight flight = context.getBean("flight", Flight.class);

        Ticket ticket = context.getBean("ticket", Ticket.class);

        flight.print();
        System.out.println("Flight ID: " + flight.getId());
        System.out.println("Ticket number: " + ticket.getNumber());
    }

    private static void runFlightApp() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("flightManagementContext.xml");
        PassengerDao passengerDao = (PassengerDao) context.getBean("passengerDao");
        System.out.println("Getting an entry for the first time");
        System.out.println(passengerDao.getPassenger(1));
        System.out.println("Getting an entry from the cache");
        System.out.println(passengerDao.getPassenger(1));
    }

    private static void runAnnotationSerializer() {
        FifaPlayer fifaPlayer = new FifaPlayer();
        fifaPlayer.setName("Cristiano Ronaldo");
        fifaPlayer.setCountry("Portugal");
        fifaPlayer.setAge(35);
        FieldSerializer fieldSerializer = new FieldSerializer();
        try {
            System.out.println(fieldSerializer.serializeObject(fifaPlayer));
        } catch (IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }
    }
}