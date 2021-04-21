package com.plural.spring.fundamentals.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SPEAKERS")
@Getter
@Setter
@NoArgsConstructor
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SPEAKER_ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "COMPANY")
    private String company;

    @Column(name = "SPEAKER_BIO")
    private String speakerBio;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "SPEAKER_PHOTO")
    private byte[] speakerPhoto;

    @ManyToMany(mappedBy = "speakers")
    @JsonIgnore
    private List<Session> sessions;
}