package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.repositories.SessionJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SessionTest {

    @Autowired
    private SessionJpaRepository repository;

    @Test
    public void testSessionFindByName() {
        List<Session> sessions = repository.findByNameContains("Java");
        Assertions.assertTrue(sessions.size() > 0);
    }

    @Test
    public void testFindSessionByLength() {
        List<Session> sessions = repository.findByLengthNot(30);
        Assertions.assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaStartingWith() {
        List<Session> sessions = repository.findByNameStartingWith("Python");
        Assertions.assertTrue(sessions.size() > 0);
    }
}