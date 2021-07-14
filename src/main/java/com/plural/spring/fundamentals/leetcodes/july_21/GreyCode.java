package com.plural.spring.fundamentals.leetcodes.july_21;

/*
Date: 07/02/2021
Problem Statement:
An n-bit gray code sequence is a sequence of 2n integers where:

    Every integer is in the inclusive range [0, 2n - 1],
    The first integer is 0,
    An integer appears no more than once in the sequence,
    The binary representation of every pair of adjacent integers differs by exactly one bit, and
    The binary representation of the first and last integers differs by exactly one bit.

Given an integer n, return any valid n-bit gray code sequence.
 */

import java.util.ArrayList;
import java.util.List;

public class GreyCode {

    public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        List<Integer> result = grayCode(n-1);
        int numToAdd = 1<<(n-1);
        for (int i=result.size() - 1; i>=0; i--) {
            result.add(numToAdd + result.get(i));
        }
        return result;
    }
}
