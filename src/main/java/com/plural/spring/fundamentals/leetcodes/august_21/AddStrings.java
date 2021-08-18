package com.plural.spring.fundamentals.leetcodes.august_21;

/*
Date: 08/10/2021
Problem Statement:
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
You must also not convert the inputs to integers directly.
 */

public class AddStrings {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int indexOne = num1.length() - 1, indexTwo = num2.length() - 1;
        int quo = 0, rem = 0;
        while (indexOne >= 0 || indexTwo >= 0) {
            int n1 = 0, n2 = 0, sum = 0;
            if (indexOne >= 0) n1 = num1.charAt(indexOne) - 48;
            if (indexTwo >= 0) n2 = num2.charAt(indexTwo) - 48;
            sum = (n1 + n2 + quo);
            rem = sum % 10;
            quo = sum / 10;
            sb.append(rem);
            indexOne--; indexTwo--;
        }
        if (quo != 0) sb.append(quo);
        return sb.reverse().toString();
    }
}