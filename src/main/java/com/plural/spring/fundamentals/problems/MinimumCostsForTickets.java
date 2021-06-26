package com.plural.spring.fundamentals.problems;

public class MinimumCostsForTickets {

    public int mincostTickets(int[] days, int[] costs) {
        int[] minCosts = new int[days[days.length - 1] + 1];
        minCosts[0] = 0;
        int daysIndex = 0;
        for (int i=1; i<minCosts.length; i++) {
            if (i < days[daysIndex]) {
                minCosts[i] = minCosts[i-1];
                continue;
            }
            int singleDay = costs[0] + minCosts[i-1];
            int sevenDay = costs[1] + minCosts[Math.max(0, i-7)];
            int thirtyDay = costs[2] + minCosts[Math.max(0, i-30)];
            minCosts[i] = Math.min(Math.min(singleDay, sevenDay), thirtyDay);
            daysIndex++;
        }
        return minCosts[minCosts.length - 1];
    }
}
