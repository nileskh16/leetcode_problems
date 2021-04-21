package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.repositories.SpeakerJpaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SpeakerTest {

    @Autowired
    private SpeakerJpaRepository repository;

    @Test
    public void testJpaAnd() {
        List<Speaker> speakers = repository.findByFirstNameAndLastName("Justin", "Clark");
        Assertions.assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaOr() {
        List<Speaker> speakers = repository.findByFirstNameOrLastName("Justin", "Clark");
        Assertions.assertTrue(speakers.size() > 0);
    }

    @Test
    public void testJpaIsNull() {
        List<Speaker> speakers = repository.findBySpeakerPhotoIsNull();
        Assertions.assertEquals(40, speakers.size());
    }

    @Test
    public void testJpaNotNull() {
        List<Speaker> speakers = repository.findBySpeakerPhotoNotNull();
        Assertions.assertEquals(0, speakers.size());
    }

    @Test
    public void testJpaOrderByAndIgnoreCase() {
        List<Speaker> speakers = repository.findByTitleContainsIgnoreCaseOrderByFirstNameAsc("Developer");
        Assertions.assertEquals(3, speakers.size());
        Assertions.assertEquals("Linda", speakers.get(0).getFirstName());
        Assertions.assertEquals(1L, speakers.get(2).getId());
    }

    @Test
    public void testJpaFirst() {
        Speaker speaker = repository.findFirstByCompanyContaining("Bank");
        Assertions.assertNotNull(speaker);
        Assertions.assertEquals("Lori", speaker.getFirstName());
    }

    @Test
    public void testJpaTop() {
        List<Speaker> speakers = repository.findTop5ByTitleContainingIgnoreCase("Developer");
        Assertions.assertEquals(3, speakers.size());
    }

    @Test
    public void testJpaDistinct() {
        List<Speaker> speakers = repository.findDistinctByCompanyContainingIgnoreCase("Software");
        Assertions.assertEquals(2, speakers.size());
    }
}
