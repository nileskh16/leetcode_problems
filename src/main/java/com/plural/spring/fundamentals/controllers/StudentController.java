package com.plural.spring.fundamentals.controllers;

import com.plural.spring.fundamentals.entities.Student;
import com.plural.spring.fundamentals.events.StudentCreationEvent;
import com.plural.spring.fundamentals.repositories.StudentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentRepositoryImpl studentRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.getAllEntries();
    }

    @PostMapping()
    public Student addStudent(@Valid @RequestBody Student student) {
        Student saveStudent = studentRepository.addEntry(student);
        applicationEventPublisher.publishEvent(new StudentCreationEvent(saveStudent));
        return saveStudent;
    }

    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable(name = "id") Long studentId) {
        return studentRepository.getAnEntryById(studentId);
    }
}