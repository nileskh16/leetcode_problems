package com.plural.spring.fundamentals.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
