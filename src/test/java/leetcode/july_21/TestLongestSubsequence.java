package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.LongestIncreasingSubsequence;
import org.junit.Assert;
import org.junit.Test;

public class TestLongestSubsequence {

    private final LongestIncreasingSubsequence subSequence;

    public TestLongestSubsequence() {
        subSequence = new LongestIncreasingSubsequence();
    }

    @Test
    public void testOne() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Assert.assertEquals(4, subSequence.lengthOfLIS(nums));
    }

    @Test
    public void testTwo() {
        int[] nums = {0, 1, 0, 3, 2, 3};
        Assert.assertEquals(4, subSequence.lengthOfLIS(nums));
    }

    @Test
    public void testThree() {
        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        Assert.assertEquals(1, subSequence.lengthOfLIS(nums));
    }

    @Test
    public void testFour() {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        Assert.assertEquals(1, subSequence.lengthOfLIS(nums));
    }

    @Test
    public void testFive() {
        int[] nums = {5, 6, 2, 3, 9, 7, 8};
        Assert.assertEquals(4, subSequence.lengthOfLIS(nums));
    }
}
