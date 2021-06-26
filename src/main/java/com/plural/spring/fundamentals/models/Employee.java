package com.plural.spring.fundamentals.models;

import lombok.Data;

@Data
public class Employee {

    private int id;
    private String name;
    private String role;
    private int age;
    private String currency;
    private double salary;

    @Override
    public String toString() {
        return String.format("%d years old %s(%d) works as %s and earns %f%s every week", age, name, id, role, salary, currency);
    }
}
