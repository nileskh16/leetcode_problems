package com.plural.spring.fundamentals.contests.amazon;

public class AmaLongestPalindromicSubString {

    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int currentLength = s.length();

        while (currentLength >= 1) {
            for (int i = 0; i + currentLength <= s.length(); i++) {
                String sub = s.substring(i, i + currentLength);
                if (isPalindrome(sub)) return sub;
            }
            currentLength--;
        }
        return s;
    }

    private boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return false;
        if (s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
