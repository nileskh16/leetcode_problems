package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long> {

    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);
    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);
    List<Speaker> findBySpeakerPhotoIsNull();
    List<Speaker> findBySpeakerPhotoNotNull();
    List<Speaker> findByTitleContainsIgnoreCaseOrderByFirstNameAsc(String title);
    Speaker findFirstByCompanyContaining(String company);
    List<Speaker> findTop5ByTitleContainingIgnoreCase(String title);
    List<Speaker> findDistinctByCompanyContainingIgnoreCase(String company);
}
