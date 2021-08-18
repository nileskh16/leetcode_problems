package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Statement:
 * Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
 * Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].
 * <p>
 * Example
 * Input: left = "4", right = "1000"
 * Output: 4
 * Explanation: 4, 9, 121, and 484 are superpalindromes.
 * Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 */

public class SuperPalindromes {

    public static void main(String[] args) {
        SuperPalindromes palindromes = new SuperPalindromes();
        System.out.println(palindromes.isStringPalindrome("abcdefggefedcba"));
    }

    public int findSuperPalindromes(String left, String right) {
        int count = 0;
        Integer first = Integer.parseInt(left);
        Integer last = Integer.parseInt(right);
        Map<Integer, Integer> squareMap = getMapOfSquares(first, last);
        for (Map.Entry<Integer, Integer> entry : squareMap.entrySet()) {
            if (entry.getValue() >= first && entry.getValue() <= last) {
                if (isStringPalindrome(String.valueOf(entry.getKey())) &&
                        isStringPalindrome(String.valueOf(entry.getValue()))) {
                    count++;
                }
            }
        }
        return count;
    }

    private Map<Integer, Integer> getMapOfSquares(Integer low, Integer high) {
        Map<Integer, Integer> squareMap = new HashMap<>();
        for(Integer i=0; i<=Math.sqrt(high); i++) {
            squareMap.put(i, i*i);
        }
        return squareMap;
    }

    private boolean isValidString(Integer first, Integer last, Integer targetNumber) {
        return targetNumber >= first && targetNumber <= last && isStringPalindrome(String.valueOf(targetNumber));
    }

    private boolean isStringPalindrome(String txt) {
        if (txt.isEmpty()) return false;
        boolean result = true;
        int start = 0;
        int end = txt.length() - 1;
        while (start <= end) {
            if (txt.charAt(start) != txt.charAt(end)) {
                result = false;
                break;
            }
            start++;
            end--;
        }
        return result;
    }
}
