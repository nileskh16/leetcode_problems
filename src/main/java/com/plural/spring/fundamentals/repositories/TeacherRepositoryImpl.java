package com.plural.spring.fundamentals.repositories;

import com.plural.spring.fundamentals.entities.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherRepositoryImpl implements CustomRepository<Teacher, Long> {

    private final Map<Long, Teacher> storage = new HashMap<>();

    @Override
    public List<Teacher> getAllEntries() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public Teacher getAnEntryById(Long id) {
        return storage.get(id);
    }

    @Override
    public Teacher addEntry(Teacher entry) {
        Long teacherId = entry.getId();
        if (!storage.containsKey(teacherId)) {
            storage.put(teacherId, entry);
        }
        return storage.get(teacherId);
    }
}
