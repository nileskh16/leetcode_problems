package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.MaxConsecutiveOnesIII;
import org.junit.Assert;
import org.junit.Test;

public class TestMaxConsecutiveOnesIII {
    private final MaxConsecutiveOnesIII consecutiveOnes;

    public TestMaxConsecutiveOnesIII() {
        consecutiveOnes = new MaxConsecutiveOnesIII();
    }

    @Test
    public void testOne() {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        Assert.assertEquals(6, consecutiveOnes.longestOnes(nums, k));
    }

    @Test
    public void testTwo() {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        Assert.assertEquals(10, consecutiveOnes.longestOnes(nums, k));
    }

    @Test
    public void testThree() {
        int[] nums = {1, 0, 1, 0, 1};
        int k = 2;
        Assert.assertEquals(5, consecutiveOnes.longestOnes(nums, k));
    }

    @Test
    public void testFour() {
        int[] nums = {0, 0, 0, 0, 0};
        int k = 4;
        Assert.assertEquals(4, consecutiveOnes.longestOnes(nums, k));
    }
}
