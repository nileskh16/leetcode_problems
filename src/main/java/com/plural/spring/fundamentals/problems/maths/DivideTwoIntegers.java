package com.plural.spring.fundamentals.problems.maths;

public class DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        long quotient = 0;
        long sum = Math.abs(divisor);
        while (sum < Math.abs((long) dividend)) {
            quotient++;
            sum += Math.abs(divisor);
        }
        if (sum == Math.abs((long) dividend)) quotient++;
        quotient = dividend < 0 && divisor > 0 || divisor < 0 && dividend > 0 ? -quotient : quotient;
        if (quotient < Integer.MIN_VALUE) quotient = Integer.MIN_VALUE;
        else if (quotient > Integer.MAX_VALUE) quotient = Integer.MAX_VALUE;
        return (int) quotient;
    }

    private int div(int dividend, int divisor) {
        if (dividend == -2147483648 && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = (dividend >= 0) == (divisor >= 0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;
        int temp = 0;
        int prev = 0;
        while (dividend - divisor >= 0) {
            int count = 0;
            temp = divisor;
            prev = 0;
            while (dividend - temp >= 0) {
                prev = temp;
                temp = temp << 1;
                count++;
            }
            result += 1 << count - 1;
            dividend -= prev;
        }
        return sign ? result : -result;
    }
}
