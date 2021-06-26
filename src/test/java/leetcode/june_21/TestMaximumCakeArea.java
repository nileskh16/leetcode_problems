package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.MaximumCakeArea;
import org.junit.Assert;
import org.junit.Test;

public class TestMaximumCakeArea {

    private final MaximumCakeArea maximumCakeArea;

    public TestMaximumCakeArea() {
        maximumCakeArea = new MaximumCakeArea();
    }

    @Test
    public void testOne() {
        int[] horizontalCuts = {1, 2, 4};
        int[] verticalCuts = {1, 3};
        Assert.assertEquals(4, maximumCakeArea.maxArea(5, 4, horizontalCuts, verticalCuts));
    }

    @Test
    public void testTwo() {
        int[] horizontalCuts = {3, 1};
        int[] verticalCuts = {1};
        Assert.assertEquals(6, maximumCakeArea.maxArea(5, 4, horizontalCuts, verticalCuts));
    }

    @Test
    public void testThree() {
        int[] horizontalCuts = {3};
        int[] verticalCuts = {3};
        Assert.assertEquals(9, maximumCakeArea.maxArea(5, 4, horizontalCuts, verticalCuts));
    }
}
