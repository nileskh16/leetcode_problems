package com.plural.spring.fundamentals.tij.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppClass implements Serializable {

    private String division;
    private String standard;
    List<Student> studentList;

    public AppClass(String division, String standard) {
        this.standard = standard;
        this.division = division;
        this.studentList = new ArrayList<>();
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    @Override
    public String toString() {
        return String.format("Class %s -> %s has %d students", division, standard, studentList.size());
    }
}
