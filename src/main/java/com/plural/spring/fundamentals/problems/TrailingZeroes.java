package com.plural.spring.fundamentals.problems;

public class TrailingZeroes {

    public int trailingZeroes(int n) {
        if (n == 0) return 0;
        int count = 0;
        for(int i=5; i<=n; i *= 5) {
            count += (n / i);
        }
        return count;
    }
}
