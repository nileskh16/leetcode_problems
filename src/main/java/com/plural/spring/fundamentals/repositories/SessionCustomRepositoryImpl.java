package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class SessionCustomRepositoryImpl implements SessionCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Session> getCustomSessionList(Integer sessionLength) {
        List<Session> sessions = entityManager.
                createQuery(String.format("select s from Session s where s.length > %d order by name desc", sessionLength))
                .getResultList();
        return sessions;
    }
}
