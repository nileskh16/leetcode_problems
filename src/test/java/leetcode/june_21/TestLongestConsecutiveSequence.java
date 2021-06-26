package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.LongestConsecutiveSequence;
import org.junit.Assert;
import org.junit.Test;

public class TestLongestConsecutiveSequence {

    private final LongestConsecutiveSequence consecutiveSequence;

    public TestLongestConsecutiveSequence() {
        consecutiveSequence = new LongestConsecutiveSequence();
    }

    @Test
    public void testOne() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Assert.assertEquals(4, consecutiveSequence.longestConsecutive(nums));
    }

    @Test
    public void testTwo() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        Assert.assertEquals(9, consecutiveSequence.longestConsecutive(nums));
    }

    @Test
    public void testThree() {
        int[] nums = {100, 4, 200, 1, 3, 2, 50, 51, 52};
        Assert.assertEquals(4, consecutiveSequence.longestConsecutive(nums));
    }
}
