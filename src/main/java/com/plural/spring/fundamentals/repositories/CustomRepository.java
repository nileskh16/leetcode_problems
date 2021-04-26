package com.plural.spring.fundamentals.repositories;

import java.util.List;

public interface CustomRepository<T, V> {
    List<T> getAllEntries();
    T getAnEntryById(V id);
    T addEntry(T entry);
}
