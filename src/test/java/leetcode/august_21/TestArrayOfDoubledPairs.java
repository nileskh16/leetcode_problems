package leetcode.august_21;

import com.plural.spring.fundamentals.leetcodes.august_21.ArrayOfDoubledPairs;
import org.junit.Assert;
import org.junit.Test;

public class TestArrayOfDoubledPairs {

    private final ArrayOfDoubledPairs arrayOfDoubledPairs;

    public TestArrayOfDoubledPairs() {
        arrayOfDoubledPairs = new ArrayOfDoubledPairs();
    }

    @Test
    public void testOne() {
        int[] nums = {3, 1, 3, 6};
        Assert.assertFalse(arrayOfDoubledPairs.canReorderDoubled(nums));
    }

    @Test
    public void testTwo() {
        int[] nums = {2, 1, 2, 6};
        Assert.assertFalse(arrayOfDoubledPairs.canReorderDoubled(nums));
    }

    @Test
    public void testThree() {
        int[] nums = {4, -2, 2, -4};
        Assert.assertTrue(arrayOfDoubledPairs.canReorderDoubled(nums));
    }

    @Test
    public void testFour() {
        int[] nums = {1, 2, 4, 16, 8, 4};
        Assert.assertFalse(arrayOfDoubledPairs.canReorderDoubled(nums));
    }

    @Test
    public void testFive() {
        int[] nums = {2, 4, 0, 0, 8, 1};
        Assert.assertTrue(arrayOfDoubledPairs.canReorderDoubled(nums));
    }

    @Test
    public void testSix() {
        int[] nums = {-5, -2};
        Assert.assertFalse(arrayOfDoubledPairs.canReorderDoubled(nums));
    }
}
