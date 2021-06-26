package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.MaximumUnitsOnTruck;
import org.junit.Assert;
import org.junit.Test;

public class TestMaximumUnitsOnTruck {

    private final MaximumUnitsOnTruck unitsOnTruck;

    public TestMaximumUnitsOnTruck() {
        unitsOnTruck = new MaximumUnitsOnTruck();
    }

    @Test
    public void testOne() {
        int[][] boxes = {{1, 3}, {2, 2}, {3, 1}};
        Assert.assertEquals(8, unitsOnTruck.maximumUnits(boxes, 4));
    }

    @Test
    public void testTwo() {
        int[][] boxes = {{5, 10}, {2, 5}, {4, 7}, {3, 9}};
        Assert.assertEquals(91, unitsOnTruck.maximumUnits(boxes, 10));
    }

}
