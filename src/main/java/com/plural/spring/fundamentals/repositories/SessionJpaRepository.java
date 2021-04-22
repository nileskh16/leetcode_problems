package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Session;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionJpaRepository extends JpaRepository<Session, Long>, SessionCustomRepository {

    @Query("select s from Session s where s.name like concat('%', ?1, '%')")
    List<Session> findByNameContains(String sessionName);

    @Query("select s from Session s where s.length != ?1")
    List<Session> findByLengthNot(Integer length);

//    @Query("select s from Session s where s.name like concat(?1, '%')")
    List<Session> findByNameStartingWith(String sessionName);

    @Query("select s from Session s where s.name like concat('%', ?1)")
    List<Session> findByNameEndingWith(String sessionName);

    @Query("select s from Session s where s.length > ?1")
    Page<Session> getShorterSessions(Integer sessionLength, Pageable pageable);
}
