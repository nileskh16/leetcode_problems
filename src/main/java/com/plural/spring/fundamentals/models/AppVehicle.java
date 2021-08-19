package com.plural.spring.fundamentals.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VEHICLES")
@Getter
@Setter
public class AppVehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    private String type;

    @Column(nullable = false)
    private String company;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private AppUser user;
}
