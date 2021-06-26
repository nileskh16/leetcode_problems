package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/21/2021
Problem Statement: Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(1));
        if (numRows == 1) return triangle;
        triangle.add(Arrays.asList(1, 1));
        if (numRows == 2) return triangle;
        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> previousRow = triangle.get(i - 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(previousRow.get(j - 1) + previousRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}
