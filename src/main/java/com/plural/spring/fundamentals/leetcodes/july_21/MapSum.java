package com.plural.spring.fundamentals.leetcodes.july_21;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

    private final Map<String, Integer> map;

    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);
    }

    public int sum(String prefix) {
        int finalSum = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) finalSum += entry.getValue();
        }
        return finalSum;
    }
}
