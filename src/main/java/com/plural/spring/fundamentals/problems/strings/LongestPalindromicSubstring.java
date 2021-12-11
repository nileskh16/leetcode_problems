package com.plural.spring.fundamentals.problems.strings;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int n = s.length();
        int palindromeStartsAt = 0, maxLen = 0;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                dp[i][j] = (s.charAt(i) == s.charAt(j))
                        &&
                        (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (j - i + 1 > maxLen)) {
                    palindromeStartsAt = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(palindromeStartsAt, palindromeStartsAt + maxLen);
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
