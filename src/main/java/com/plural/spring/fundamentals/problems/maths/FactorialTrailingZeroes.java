package com.plural.spring.fundamentals.problems.maths;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
