package com.plural.spring.fundamentals.leetcodes.june_21;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarOne {

    private TreeMap<Integer, Integer> dates = new TreeMap<>();

    public MyCalendarOne() {
        dates.put(Integer.MAX_VALUE, Integer.MAX_VALUE);
    }

    public boolean book(int start, int end) {
        Map.Entry<Integer, Integer> highestEntry = dates.higherEntry(start);
        boolean res = end <= highestEntry.getValue();
        if (res) dates.put(end, start);
        return res;
    }
}