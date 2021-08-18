package com.plural.spring.fundamentals.leetcodes.july_21;

/*
Date: 07/26/2021
Problem Statement:
Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.
 */

public class NonNegativeIntegersWithoutTwoOnes {

    private int counter;
    private boolean need = true;

    public int findIntegers(int n) {
        int pos = calc(n + 1);
        if (need) {
            for (int i = pos; i <= n; i++) {
                if (check(i)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    private int calc(int n) {
        if (n < 1024) {
            return 0;
        }
        int pos = 8;
        int add = 5;
        int half = 3;
        while (pos * 2 <= n) {
            int tmp = add;
            add += half;
            half = tmp;
            pos *= 2;
        }
        counter += add;
        n -= pos;
        if (n >= pos * 3 / 8) {
            pos += pos * 3 / 8;
            counter += half;
            need = false;
            return pos;
        } else {
            return pos + calc(n);
        }
    }

    private boolean check(int n) {
        int i = 31;
        while (i > 0) {
            if ((n & (1 << i)) != 0 && (n & (1 << (i - 1))) != 0)
                return false;
            i--;
        }
        return true;
    }
}
