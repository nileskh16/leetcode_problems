package com.plural.spring.fundamentals.leetcodes.may_21;

public class MaxPointsFromCards {

    public int drawMaxPointsFromCards(int[] cardPoints, int k) {
        int[] sums = new int[k*2];
        int maxSum = 0;
        int len = cardPoints.length;
        int sumLen = sums.length;
        sums[0] = cardPoints[0];
        sums[sumLen - 1] = cardPoints[len - 1];

        for (int i=1; i<k; i++) {
            sums[i] = cardPoints[i] + sums[i-1];
            sums[sumLen-i-1] = cardPoints[len-i-1] + sums[sumLen-i];
        }

        for (int i=0; i<=k; i++) {
            int leftIndex = (k-i-1);
            int rightIndex = sumLen - i;
            int tempSum = 0;
            if (leftIndex >= 0 && leftIndex < sumLen) {
                tempSum += sums[leftIndex];
            }

            if (rightIndex >= 0 && rightIndex < sumLen) {
                tempSum += sums[rightIndex];
            }
            maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum;
    }

    public int getMaxSumFromCards(int[] cardPoints, int k) {

        int sum = 0;
        int counter = 0;
        int startIndex = 0;
        int lastIndex = cardPoints.length - 1;
        while (counter < k) {
            if (cardPoints[startIndex] > cardPoints[lastIndex]) {
                sum += cardPoints[startIndex];
                startIndex++;
            } else {
                sum += cardPoints[lastIndex];
                lastIndex--;
            }
            counter++;
        }
        return sum;
    }
}
