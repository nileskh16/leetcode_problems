package com.plural.spring.fundamentals.problems.maths;

public class Sqrt {

    public int mySqrt(int x) {
        if (x == 0) return 0;
        int i = 1;
        while (true) {
            if (x / i == i) return i;
            if (x / i < i) return i-1;
            i++;
        }
    }
}
