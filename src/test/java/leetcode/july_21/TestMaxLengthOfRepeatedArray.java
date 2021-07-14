package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.MaximumLengthOfRepeatedArray;
import org.junit.Assert;
import org.junit.Test;

public class TestMaxLengthOfRepeatedArray {

    private final MaximumLengthOfRepeatedArray lengthOfRepeatedArray;

    public TestMaxLengthOfRepeatedArray() {
        lengthOfRepeatedArray = new MaximumLengthOfRepeatedArray();
    }

    @Test
    public void testOne() {
        int[] nums1 = {2, 1, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        Assert.assertEquals(3, lengthOfRepeatedArray.findLength(nums1, nums2));
    }

    public void testTwo() {
        int[] nums1 = {0, 0, 0, 0, 0};
        int[] nums2 = {0, 0, 0, 0, 0};
        Assert.assertEquals(5, lengthOfRepeatedArray.findLength(nums1, nums2));
    }
}
