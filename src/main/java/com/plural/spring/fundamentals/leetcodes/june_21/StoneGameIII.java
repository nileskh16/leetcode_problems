package com.plural.spring.fundamentals.leetcodes.june_21;

public class StoneGameIII {

    public int stoneGameVII(int[] stones) {
        boolean alice = true;
        int aliceSum = getArraySum(stones);
        int bobSum = 0;
        int leftIndex = 0;
        int rightIndex = stones.length - 1;

        while (leftIndex <= rightIndex) {
            if (alice) {
                alice = false;
                if (stones[leftIndex] < stones[rightIndex]) {
                    aliceSum -= stones[leftIndex];
                    leftIndex++;
                } else {
                    aliceSum -= stones[rightIndex];
                    rightIndex--;
                }
            } else {
                alice = true;
                if (stones[leftIndex] > stones[rightIndex]) {
                    bobSum = aliceSum - stones[leftIndex];
                    leftIndex++;
                } else {
                    bobSum = aliceSum - stones[rightIndex];
                    rightIndex--;
                }
            }
        }

        return Math.abs(aliceSum - bobSum);
    }

    private int getArraySum(int[] stones) {
        int sum = 0;
        for (int stone : stones) sum += stone;
        return sum;
    }
}
