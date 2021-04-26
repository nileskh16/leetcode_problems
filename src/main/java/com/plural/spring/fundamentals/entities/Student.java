package com.plural.spring.fundamentals.entities;

import com.plural.spring.fundamentals.annotations.UniqueId;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class Student {

    @UniqueId
    private Long id;

    @NotEmpty(message = "First name is required")
    private String firstName;

    @NotEmpty(message = "Last name is required")
    private String lastName;

    @NotEmpty(message = "Email Address is required")
    @Email(message = "Valid message is required")
    private String emailId;
}
