package com.plural.spring.fundamentals.problems.strings;

/*
Problem Statement:
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */

public class ReverseIntegers {
    public int reverse(int x) {
        try {
            StringBuilder value = new StringBuilder(String.valueOf(x));
            char[] chars = value.toString().toCharArray();
            int total = value.length();
            boolean isNegative = false;
            for (int i = 0; i < total / 2; i++) {
                char temp = chars[i];
                chars[i] = chars[total - i - 1];
                chars[total - i - 1] = temp;
            }
            value.setLength(0);
            for (char ch : chars) {
                if (ch == '-') isNegative = true; else value.append(ch);
            }
            int result = Integer.parseInt(value.toString());
            return isNegative ? -result : result;
        } catch (IllegalArgumentException ex) {
            return 0;
        }
    }
}
