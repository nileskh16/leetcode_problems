package com.plural.spring.fundamentals.leetcodes.june_21;

/*
Date: 06/08/2021
Problem Statement: You are given an integer array cost where cost[i] is the cost of ith step on a staircase.
Once you pay the cost, you can either climb one or two steps.
You can either start from the step with index 0, or the step with index 1. Return the minimum cost to reach the top of the floor.
 */

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] minCosts = new int[cost.length + 1];
        minCosts[0] = cost[0];
        minCosts[1] = cost[1];

        for (int i = 2; i < minCosts.length; i++) {
            minCosts[i] = (i == cost.length ? 0 : cost[i]) + Math.min(minCosts[i - 1], minCosts[i - 2]);
        }

        return minCosts[cost.length];
    }
}
