package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.MaximumGap;
import org.junit.Assert;
import org.junit.Test;

public class TestMaximumGap {

    private final MaximumGap gap;

    public TestMaximumGap() {
        gap = new MaximumGap();
    }

    @Test
    public void testOne() {
        int[] nums = {3, 6, 9, 1};
        Assert.assertEquals(3, gap.maximumGap(nums));
    }

    @Test
    public void testTwo() {
        int[] nums = {10};
        Assert.assertEquals(0, gap.maximumGap(nums));
    }
}
