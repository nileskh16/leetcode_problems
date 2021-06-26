package com.plural.spring.fundamentals.leetcodes.june_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && isPalindrome(words[i].concat(words[j]))) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }
}
