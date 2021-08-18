package com.plural.spring.fundamentals.leetcodes.august_21;

/*
Date: 08/13/2021
Problem Statement:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.
 */

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<>();
        for (String str : strs) {
            String key = sortChars(str);
            store.putIfAbsent(key, new ArrayList<>());
            store.get(key).add(str);
        }
        return new ArrayList<>(store.values());
    }

    private String sortChars(String str) {
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
}
