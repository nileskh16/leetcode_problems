package com.plural.spring.fundamentals.leetcodes.may_21;

public class RangeSumQuery2D {

    private final int[][] rowSum;

    public RangeSumQuery2D(int[][] matrix) {
        int R = matrix.length;
        int C = matrix[0].length;
        rowSum = new int[R][C+1];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                rowSum[r][c+1] = rowSum[r][c] + matrix[r][c];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            sum += rowSum[row][col2 + 1] - rowSum[row][col1];
        }
        return sum;
    }
}
