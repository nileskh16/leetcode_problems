package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpeakerJpaRepository extends JpaRepository<Speaker, Long> {

    @Query("select s from Speaker s where s.firstName=?1 and s.lastName=?2")
    List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Speaker s where s.firstName=?1 or s.lastName=?2")
    List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);

    @Query("select s from Speaker s where s.speakerPhoto is null")
    List<Speaker> findBySpeakerPhotoIsNull();

    @Query("select s from Speaker s where s.speakerPhoto is not null")
    List<Speaker> findBySpeakerPhotoNotNull();

    @Query("select s from Speaker s where lower(s.title) like lower(concat('%', ?1, '%')) order by s.firstName asc")
    List<Speaker> findByTitleContainsIgnoreCaseOrderByFirstNameAsc(String title);

//    @Query("select s from Speaker s where s.company like lower(concat('%', ?1, '%'))")
    Speaker findFirstByCompanyContaining(String company);

//    @Query("select s from Speaker s where lower(s.title) like lower(concat('%', ?1, '%'))")
    List<Speaker> findTop5ByTitleContainingIgnoreCase(String title);

    @Query("select distinct s from Speaker s where lower(s.company) like lower(concat('%', ?1, '%'))")
    List<Speaker> findDistinctByCompanyContainingIgnoreCase(String company);
}
