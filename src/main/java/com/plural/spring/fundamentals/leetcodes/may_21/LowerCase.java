package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.*;

public class LowerCase {

    public static void main(String[] args) {
        LowerCase lowerCase = new LowerCase();
        System.out.println(lowerCase.getDistinctChars("God does not play dice with the universe"));
        System.out.println(lowerCase.getDistinctChars("Stop telling god what to do with his dice"));
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            int charCode = (int) s.charAt(i);
            if (charCode >= 65 && charCode <= 90) {
                charCode = (charCode - 65) + 97;
            }
            sb.append((char) charCode);
        }
        return sb.toString();
    }
    
    public String getDistinctChars(String s) {
        Map<Character, Integer> countMap = new TreeMap<>();
        for (char ch : s.toLowerCase().toCharArray()) {
            if (!countMap.containsKey(ch)) {
                countMap.put(ch, 0);
            }
            countMap.put(ch, countMap.get(ch) + 1);
        }
        return countMap.toString();
    }
}
