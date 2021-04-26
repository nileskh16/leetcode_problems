package com.plural.spring.fundamentals.controllers;

import com.plural.spring.fundamentals.entities.Teacher;
import com.plural.spring.fundamentals.repositories.TeacherRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherRepositoryImpl teacherRepository;

    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherRepository.getAllEntries();
    }

    @GetMapping("/{id}")
    public Teacher findTeacherById(@PathVariable(name = "id") Long teacherId) {
        return teacherRepository.getAnEntryById(teacherId);
    }

    @PostMapping
    public Teacher addTeacher(@Valid @RequestBody Teacher teacher) {
        return teacherRepository.addEntry(teacher);
    }
}