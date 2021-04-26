package com.plural.spring.fundamentals.controllers;

import com.plural.spring.fundamentals.entities.Student;
import com.plural.spring.fundamentals.repositories.StudentRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepositoryImpl studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllEntries();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.addEntry(student);
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable(name = "id") Long studentId) {
        return studentRepository.getAnEntryById(studentId);
    }
}
