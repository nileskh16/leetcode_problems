package com.plural.spring.fundamentals.contests.microsoft;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MinStepsForEqualPiles {

    private int i = 0;

    public int minSteps(int[] piles) {
        List<Integer> pls = Arrays.stream(piles).boxed().sorted((a, b) -> Integer.compare(b, a)).collect(Collectors.toList());
        int ans = 0;
        for (int i = 0; i < piles.length - 1; i++) {
            if (pls.get(i) > pls.get(i + 1)) ans += (i + 1);
        }
        return ans;
    }

    public int findMaxK(int[] nums) {
        if (nums == null || nums.length <= 1) return 0;
        List<Integer> ent = Arrays.stream(nums).boxed().sorted((a, b) -> Integer.compare(b, a)).collect(Collectors.toList());
        int ans = 0, i = 0, j = nums.length - 1;
        if (ent.get(i) <= 0 || ent.get(j) > 0) return ans;
        while (i < nums.length) {
            int num = ent.get(i);
            if (num <= 0) break;
            while (ent.get(j) < -num) {
                j--;
            }
            if (ent.get(j) == -num) {
                return num;
            }
            i++;
        }
        return ans;
    }

    public String decodeString(String str) {
        String result = "";
        StringBuilder ans = new StringBuilder();
        int count = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int idx = i;
                while (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    i++;
                }
                count = Integer.parseInt(str.substring(idx, i));
            } else if (ch == '[') {
                i++;
                result = decodeString(str);
                ans.append(formString(result, count));
            } else if (ch >= 'a' && ch <= 'z') {
                ans.append(ch);
            } else if (ch == ']') {
                i++;
                return ans.toString();
            }
        }
        return ans.toString();
    }

    private String formString(String str, int freq) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < freq; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public int findLargestCharacter(String str) {
        int[] dp = new int[52];
        for (char ch : str.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                dp[ch - 'A']++;
            } else if (ch >= 'a' && ch <= 'z') {
                dp[ch - 'a' + 26]++;
            }
        }

        for (int idx = 25; idx >= 0; idx--) {
            if (dp[idx] > 0 && dp[idx + 26] > 0) return 'A' + idx;
        }

        return -1;
    }

    public String findMaxSubstring(String input) {
        String ans = "";
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                String temp = input.substring(i, j);
                if (temp.compareTo(ans) > 0) ans = temp;
            }
        }
        return ans;
    }
}
