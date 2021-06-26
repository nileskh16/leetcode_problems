package com.plural.spring.fundamentals.problems;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        return getNumericValue(map, s);
    }

    private int getNumericValue(Map<String, Integer> map, String s) {
        int sum = 0;
        int index = s.length() - 1;
        while (index >= 0) {
            int value = 0;
            if (s.charAt(index) == 'I') {
                value = 1;
                index--;
            }
            else {
                if (index == 0) {
                    value = map.get(s.substring(index, index + 1));
                    index--;
                }
                else {
                    if (map.containsKey(s.substring(index - 1, index + 1))) {
                        value = map.get(s.substring(index - 1, index + 1));
                        index -= 2;
                    } else {
                        value = map.get(s.substring(index, index + 1));
                        index--;
                    }
                }
            }
            sum += value;
        }
        return sum;
    }
}
