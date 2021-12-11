package com.plural.spring.fundamentals.contests.amazon;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class AmaGroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String encodedStr = encodeString(s);
            map.putIfAbsent(encodedStr, new LinkedList<>());
            map.get(encodedStr).add(s);
        }
        return new LinkedList<>(map.values());
    }

    private String encodeString(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch - 'a']++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) ans.append('a' + i).append(arr[i]);
        }
        return ans.toString();
    }
}
