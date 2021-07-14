package com.plural.spring.fundamentals.leetcodes.july_21;

public class DecodeWaysII {

    public int numDecodings(String s) {
        int mod = 1000000007;

        long[] dp = new long[s.length()];

        if (s.charAt(0) == '0') {
            return 0;
        }

        dp[0] = s.charAt(0) == '*' ? 9 : 1;

        for (int i = 1; i < s.length(); i++) {

            char prev = s.charAt(i - 1);
            char cur = s.charAt(i);

            long incPrev = 0;
            if (prev == '*') {
                if (cur == '*') {
                    incPrev = 15;
                } else {
                    if (cur > '6') {
                        incPrev = 1;
                    } else {
                        incPrev = 2;
                    }
                }
            } else if (prev == '1') {
                if (cur == '*') {
                    incPrev = 9;
                } else {
                    incPrev = 1;
                }
            } else if (prev == '2') {
                if (cur == '*') {
                    incPrev = 6;
                } else if (cur <= '6') {
                    incPrev = 1;
                }
            }
            long incCur = 0;
            if (cur == '*') {
                incCur = 9;
            } else if (cur > '0') {
                incCur = 1;
            }
            long incPrevTotal = (incPrev * (i > 1 ? dp[i - 2] : 1)) % mod;
            long incCurTotal = (incCur * dp[i - 1]) % mod;

            dp[i] = (incPrevTotal + incCurTotal) % mod;
        }
        return (int) dp[s.length() - 1];
    }
}
