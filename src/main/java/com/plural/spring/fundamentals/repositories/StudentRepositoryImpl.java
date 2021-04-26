package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements CustomRepository<Student, Long> {

    private final Map<Long, Student> storage = new HashMap<>();

    @Override
    public List<Student> getAllEntries() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Student getAnEntryById(Long id) {
        return storage.get(id);
    }

    @Override
    public Student addEntry(Student entry) {
        Long studentId = entry.getId();
        if (!storage.containsKey(studentId)) {
            storage.put(studentId, entry);
        }
        return storage.get(studentId);
    }
}
