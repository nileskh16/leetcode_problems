package com.plural.spring.fundamentals.problems.strings;

/*
Problem Statement:
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    private Map<Character, Integer> charMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.put(ch, map.get(ch) + 1);
        }
        return map;
    }

    private boolean compareMaps(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.keySet().size() != map2.keySet().size()) return false;
        for (char key : map1.keySet()) {
            if (map1.get(key) != map2.get(key)) return false;
        }
        return true;
    }
}
