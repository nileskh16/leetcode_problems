package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.MaximumEraserValue;
import org.junit.Assert;
import org.junit.Test;

public class TestMaximumEraserValue {

    private final MaximumEraserValue eraserValue;

    public TestMaximumEraserValue() {
        eraserValue = new MaximumEraserValue();
    }

    @Test
    public void testOne() {
        int[] nums = {4, 2, 4, 5, 6};
        Assert.assertEquals(17, eraserValue.maximumUniqueSubarray(nums));
    }

    @Test
    public void testTwo() {
        int[] nums = {5, 2, 1, 2, 5, 2, 1, 2, 5};
        Assert.assertEquals(8, eraserValue.maximumUniqueSubarray(nums));
    }

    @Test
    public void testThree() {
        int[] nums = {4, 2, 2, 5, 6};
        Assert.assertEquals(13, eraserValue.maximumUniqueSubarray(nums));
    }

    @Test
    public void testFour() {
        int[] nums = {1, 2, 3, 4, 5, 5, 6};
        Assert.assertEquals(15, eraserValue.maximumUniqueSubarray(nums));
    }
}
