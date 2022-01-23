package com.plural.spring.fundamentals.problems.strings;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

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

    private static List<String> getTagContent(String input) {
        List<String> ans = new LinkedList<>();
        Deque<String> stack = new LinkedList<>();
        boolean isTagEnd = false;
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '<') {
                i++;
                isTagEnd = i < input.length() && input.charAt(i) == '/';
                if (isTagEnd) i++;
                StringBuilder tagName = new StringBuilder();
                while (i < input.length() && input.charAt(i) != '>') {
                    tagName.append(input.charAt(i));
                    i++;
                }
                if (i < input.length() && input.charAt(i) == '>') {
                    if (tagName.length() == 0) continue;
                    if (isTagEnd) {
                        String openTag = stack.pop();
                        if (tagName.toString().equals(openTag) && content.length() > 0) ans.add(content.toString());
                    } else stack.push(tagName.toString());
                }
                content.setLength(0);
            } else {
                content.append(ch);
            }
        }
        return ans;
    }
}
