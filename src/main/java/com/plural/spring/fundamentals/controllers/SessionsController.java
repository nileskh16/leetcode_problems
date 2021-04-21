package com.plural.spring.fundamentals.controllers;

import com.plural.spring.fundamentals.entities.Session;
import com.plural.spring.fundamentals.repositories.SessionJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/sessions/")
public class SessionsController {

    @Autowired
    private SessionJpaRepository sessionJpaRepository;

    @GetMapping
    public List<Session> getAllSessions(@RequestParam(required = false) String name) {
        return sessionJpaRepository.findAll();
    }

    @GetMapping("{id}")
    public Session getSessionById(@PathVariable(name = "id") Long id) {
        return sessionJpaRepository.getOne(id);
    }

    @PostMapping
    public Session createSession(@RequestBody final Session session) {
        return sessionJpaRepository.saveAndFlush(session);
    }

    @PutMapping(value = "{id}")
    public Session updateSession(@PathVariable Long id, @RequestBody final Session session) {
        Session savedSession = sessionJpaRepository.getOne(id);
        BeanUtils.copyProperties(session, savedSession, "sessionId");
        return sessionJpaRepository.saveAndFlush(savedSession);
    }
}
