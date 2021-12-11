package com.plural.spring.fundamentals.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RichestCustomer {

    public static void main(String[] args) {
        RichestCustomer customer = new RichestCustomer();
        customer.printChessBoard(2);
        System.out.println(customer.numOfOddCelebrations(new int[]{4, 8, 2, 8, 9}));
    }

    public int maximumWealth(int[][] accounts) {
        int maxSum = 0;
        for (int[] account : accounts) {
            int wealth = Arrays.stream(account).reduce(0, Integer::sum);
            if (maxSum < wealth) maxSum = wealth;
        }
        return maxSum;
    }

    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) count++;
            }
        }
        return count;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> ans = new ArrayList<>(candies.length);
        int max = candies[0];
        for (int i = 1; i < candies.length; i++) if (max < candies[i]) max = candies[i];

        for (int i = 0; i < candies.length; i++) {
            ans.add(i, candies[i] + extraCandies >= max);
        }
        return ans;
    }

    public boolean checkIfPangram(String sentence) {
        boolean[] visited = new boolean[26];
        for (char ch : sentence.toCharArray()) {
            visited[ch - 'a'] = true;
        }

        for (boolean b : visited) {
            if (!b) return false;
        }
        return true;
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);
        int min = nums[0];
        int max = nums[nums.length - 1];
        return gcdRec(max, min);
    }

    private int gcdRec(int a, int b) {
        if (b == 0) return a;
        if (a == 0) return b;
        return gcdRec(b, a % b);
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        if (s.isEmpty() || s.equals(t)) return true;

        int index = 0;
        int tempIndex = 0;
        char current = s.charAt(tempIndex);
        while (index < t.length()) {
            if (t.charAt(index) == current) {
                tempIndex++;
                if (tempIndex >= s.length()) return true;
                current = s.charAt(tempIndex);
            }
            index++;
        }
        return false;
    }

    public void duplicateZeros(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            if (arr[index] == 0) {
                shiftElements(arr, index);
                index += 2;
            } else {
                index++;
            }
        }
    }

    private void shiftElements(int[] arr, int stopIndex) {
        for (int i = arr.length - 1; i > stopIndex; i--) {
            if (i > 0) arr[i] = arr[i - 1];
        }
    }

    public int longestPalindrome(String s) {
        int[] count = new int[52];
        boolean oddFound = false;
        for (char ch : s.toCharArray()) {
            if (ch < 'a') count[ch - 'A']++;
            else count[ch - 'A' - 6]++;
        }
        int maxLen = 0;
        for (int cnt : count) {
            if (cnt % 2 == 0) maxLen += cnt;
            else {
                oddFound = true;
                maxLen += cnt - 1;
            }
        }
        if (oddFound) maxLen++;
        return maxLen;
    }

    private void printChessBoard(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print((i + j) % 2 == 0 ? "W " : "B ");
            }
            System.out.println("");
        }
    }

    private int numOfOddCelebrations(int[] daysOfCelebration) {
        int[] dp = new int[31];
        for (int day : daysOfCelebration) {
            if (day <= 31 && day > 0) dp[day - 1]++;
        }
        int count = 0;
        for (int num : dp) {
            if (num % 2 == 1) count++;
        }
        return count;
    }
}
