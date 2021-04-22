package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.repositories.SessionJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

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
        List<Session> sessions = repository.findByNameStartingWith("Java");
        Assertions.assertTrue(sessions.size() > 0);
    }

    @Test
    public void testJpaCustomRepository() {
        List<Session> sessions = repository.getCustomSessionList(30);
        Assertions.assertEquals(43, sessions.size());
    }

    @Test
    public void testJpaPagination() {
        Page<Session> sessions = repository.getShorterSessions(30,
                PageRequest.of(1, 7, Sort.by(Sort.Direction.DESC, "name")));
        Assertions.assertEquals(7, sessions.getNumberOfElements());
    }
}