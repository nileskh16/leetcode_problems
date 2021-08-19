package com.plural.spring.fundamentals;

import com.plural.spring.fundamentals.models.AppAddress;
import com.plural.spring.fundamentals.models.AppUser;
import com.plural.spring.fundamentals.models.AppVehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ConferenceApplication {

    public static void main(String[] args) {
        List<AppUser> users = getAppUsers(2);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (AppUser user : users) {
                session.persist(user);
            }
            transaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    public static List<AppUser> getAppUsers(int length) {
        List<AppUser> users = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            AppAddress appAddress = new AppAddress();
            appAddress.setStreetName("Street " + i);
            appAddress.setCityName("Detroit");
            appAddress.setStateName("Michigan");
            appAddress.setZipCode("40050" + i);

            AppVehicle vehicle = new AppVehicle();
            vehicle.setCompany("BMW");
            vehicle.setType("SUV");
            vehicle.setName("Q7");

            AppUser user = new AppUser();
            user.setFirstName("Cristian");
            user.setLastName("Harv");
            user.setEmailAddress(i + "ch@us.com");
            user.setAge(45);
            user.getAddresses().add(appAddress);
            user.getVehicles().add(vehicle);
            vehicle.setUser(user);
            users.add(user);
        }
        return users;
    }
}