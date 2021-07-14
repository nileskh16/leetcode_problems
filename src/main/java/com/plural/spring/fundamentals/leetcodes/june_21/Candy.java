package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/28/2021
Problem Statement: There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
You are giving candies to these children subjected to the following requirements:
    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
Return the minimum number of candies you need to have to distribute the candies to the children.
 */

import java.util.Arrays;

public class Candy {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i=1; i<ratings.length; i++) {
            if (ratings[i] > ratings[i-1]) candies[i] = candies[i-1] + 1;
        }
        for (int i=ratings.length - 2; i>=0; i--) {
            if (ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }
        int sum = 0;
        for (int candy: candies) sum += candy;
        return sum;
    }
}
