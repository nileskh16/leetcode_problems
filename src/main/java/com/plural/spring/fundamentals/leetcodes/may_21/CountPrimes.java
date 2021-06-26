package com.plural.spring.fundamentals.leetcodes.may_21;

public class CountPrimes {

    public static void main(String[] args) {
        CountPrimes countPrimes = new CountPrimes();
        System.out.println(countPrimes.getCount(10));
    }

    public int getCount(int num) {
        if (num < 2) return 0;
        boolean[] nonPrimes = new boolean[num];
        nonPrimes[0] = true;
        nonPrimes[1] = true;
        int count = 0;
        int startPrime = 2;
        while (startPrime < num) {
            if (!nonPrimes[startPrime]) {
                count++;
                markNonPrimes(nonPrimes, num, startPrime);
            }
            startPrime++;
        }
        return count;
    }

    private void markNonPrimes(boolean[] nonPrimes, int num, int prime) {
        int startFactor = 2;
        while (startFactor * prime < num) {
            nonPrimes[startFactor * prime] = true;
            startFactor++;
        }
    }
}
