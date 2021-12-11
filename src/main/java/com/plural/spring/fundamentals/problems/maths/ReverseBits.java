package com.plural.spring.fundamentals.problems.maths;

public class ReverseBits {

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }

    private int getInteger(String num) {
        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            result += (int) (Integer.parseInt(String.valueOf(num.charAt(i))) * Math.pow(2.0, i));
        }
        return result;
    }
}
