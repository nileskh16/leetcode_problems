package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.MinCostClimbingStairs;
import org.junit.Assert;
import org.junit.Test;

public class TestMinCostClimbingStairs {

    private final MinCostClimbingStairs costClimbingStairs;

    public TestMinCostClimbingStairs() {
        costClimbingStairs = new MinCostClimbingStairs();
    }

    @Test
    public void testOne() {
        int[] cost = {10, 15, 20};
        Assert.assertEquals(15, costClimbingStairs.minCostClimbingStairs(cost));
    }

    @Test
    public void testTwo() {
        int[] costs = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Assert.assertEquals(6, costClimbingStairs.minCostClimbingStairs(costs));
    }
}
