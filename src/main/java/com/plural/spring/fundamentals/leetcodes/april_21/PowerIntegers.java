package com.plural.spring.fundamentals.leetcodes.april_21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PowerIntegers {

    public static void main(String[] args) {
        for (Integer powerNumber : new PowerIntegers().getPowerIntegers(2, 3, 10)) {
            System.out.println(powerNumber);
        }
    }

    public List<Integer> getPowerIntegers(int x, int y, int bound) {
        Set<Integer> targetNumbers = new HashSet<>();
        int i = getHighestPower(bound, x);
        int j = getHighestPower(bound, y);
        if (bound > 0) {
            for (int row=0; row<=i; row++) {
                for (int col=0; col<=j; col++) {
                    double num = Math.pow(x, row) + Math.pow(y, col);
                    if (bound >= num) targetNumbers.add((int) num);
                }
            }
        }
        return new ArrayList<>(targetNumbers);
    }

    private int getHighestPower(int bound, int source) {
        if (bound == 0) return 0;
        if (source <= 1) return source;
        int count = 0;
        while (bound >= Math.pow(source, count)) {
            count++;
        }
        return count - 1;
    }
}
