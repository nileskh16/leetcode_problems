package com.plural.spring.fundamentals.contests.apple;

import java.util.HashSet;
import java.util.Set;

public class AppleLongestSubstringWithoutRepetitions {

    public int lengthOfLongestSubstring(String str) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int max = 0;

        while (str.length() > right) {
            char current = str.charAt(right);
            if (!set.contains(current)) {
                set.add(current);
                right++;
            } else {
                max = Math.max(max, (right - left));
                left = right;
                set.clear();
            }
        }
        max = Math.max(max, (right - left));
        return max;
    }
}
