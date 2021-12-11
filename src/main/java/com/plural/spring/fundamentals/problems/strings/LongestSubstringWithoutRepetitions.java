package com.plural.spring.fundamentals.problems.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepetitions {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (s.length() > right) {
            char current = s.charAt(right);

            if (!set.contains(current)) {
                set.add(current);
                max = Math.max(max, (right - left) + 1);
                ++right;
            } else {
                set.remove(s.charAt(left));
                ++left;
            }
        }
        return max;
    }
}
