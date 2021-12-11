package com.plural.spring.fundamentals.problems;

import com.plural.spring.fundamentals.problems.dp.MinimumCostsForTickets;
import org.junit.Assert;
import org.junit.Test;

public class TestMinimumCostForTickets {
    private final MinimumCostsForTickets minimumCostsForTickets;

    public TestMinimumCostForTickets() {
        minimumCostsForTickets = new MinimumCostsForTickets();
    }

    @Test
    public void testOne() {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        Assert.assertEquals(11, minimumCostsForTickets.mincostTickets(days, costs));
    }

    @Test
    public void testTwo() {
        int[] days = {1,2,3,4,5,6,7,8,9,10,30,31};
        int[] costs = {2, 7, 15};
        Assert.assertEquals(17, minimumCostsForTickets.mincostTickets(days, costs));
    }
}
