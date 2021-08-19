package com.plural.spring.fundamentals.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "APP_USER")
@Getter
@Setter
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "FIRST_NAME", nullable = false, length = 1001)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 1001)
    private String lastName;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String emailAddress;

    @Column(name = "AGE")
    private int age;

    @ElementCollection
    Set<AppAddress> addresses = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    List<AppVehicle> vehicles = new ArrayList<>();
}
