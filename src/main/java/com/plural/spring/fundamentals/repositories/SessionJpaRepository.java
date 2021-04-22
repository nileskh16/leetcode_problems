package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SessionJpaRepository extends JpaRepository<Session, Long> {

    @Query("select s from Session s where s.name like concat('%', ?1, '%')")
    List<Session> findByNameContains(String sessionName);

    @Query("select s from Session s where s.length != ?1")
    List<Session> findByLengthNot(Integer length);

//    @Query("select s from Session s where s.name like concat(?1, '%')")
    List<Session> findByNameStartingWith(String sessionName);

    @Query("select s from Session s where s.name like concat('%', ?1)")
    List<Session> findByNameEndingWith(String sessionName);
}
