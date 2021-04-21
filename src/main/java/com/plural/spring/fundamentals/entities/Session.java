package com.plural.spring.fundamentals.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SESSIONS")
@Getter
@Setter
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SESSION_ID")
    private Long id;

    @Column(name = "SESSION_NAME", length = 80)
    private String name;

    @Column(name = "SESSION_DESCRIPTION", length = 1024)
    private String description;

    @Column(name = "SESSION_LENGTH")
    private Integer length;

    @ManyToMany
    @JoinTable(
            name = "SESSION_SPEAKERS",
            joinColumns = @JoinColumn(name = "SESSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "SPEAKER_ID"))
    private List<Speaker> speakers;
}
