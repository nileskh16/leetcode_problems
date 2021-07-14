package com.plural.spring.fundamentals.problems;

/*
Problem Statement:
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n),
ans[i] is the number of 1's in the binary representation of i.
 */

public class CountingBits {

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        result[0] = 0;
        if (n == 0) return result;
        result[1] = 1;
        if (n == 1) return result;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i / 2] + result[i % 2];
        }
        return result;
    }
}
