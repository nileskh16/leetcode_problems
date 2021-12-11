package com.plural.spring.fundamentals.contests.apple;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AppLRUCache {

    private final Deque<Integer> indices;
    private final Map<Integer, Integer> store;
    private final int capacity;
    private int currentCount = 0;

    public AppLRUCache(int capacity) {
        this.capacity = capacity;
        indices = new LinkedList<>();
        store = new HashMap<>(capacity);
    }

    public int get(int key) {
        int result = store.getOrDefault(key, -1);
        if (result != -1) {
            indices.remove(key);
            indices.offer(key);
        }
        return result;
    }

    public void put(int key, int value) {
        int oldValue = store.getOrDefault(key, -1);
        if (currentCount == capacity) {
            if (oldValue == -1) {
                int lruIndex = indices.remove();
                store.remove(lruIndex);
            }
        } else {
            if (oldValue == -1) currentCount++;
        }
        store.put(key, value);
        if (oldValue != -1) indices.remove(key);
        indices.offer(key);
    }
}
