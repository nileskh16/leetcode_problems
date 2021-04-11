package com.plural.spring.fundamentals.services;

import com.plural.spring.fundamentals.models.Speaker;
import com.plural.spring.fundamentals.repository.SpeakerRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SpeakerServiceImpl implements SpeakerService<Speaker> {

//    @Autowired
    private SpeakerRepository<Speaker> speakerRepository;

//    @Autowired
//    public SpeakerServiceImpl(SpeakerRepository speakerRepository) {
//        this.speakerRepository = speakerRepository;
//    }

    @Autowired
    public void setSpeakerRepository(SpeakerRepository<Speaker> speakerRepository) {
        this.speakerRepository = speakerRepository;
    }

    @Override
    public List<Speaker> findAllEntities() {
        return speakerRepository.findAll();
    }
}
