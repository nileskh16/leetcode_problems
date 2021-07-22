package com.plural.spring.fundamentals.tij.models;

import java.io.Serializable;

public class Student implements Serializable {

    private String username;
    private transient String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("Student %s is protected by password %s", username, password);
    }
}
