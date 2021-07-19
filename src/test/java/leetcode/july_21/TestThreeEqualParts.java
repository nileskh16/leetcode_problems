package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.ThreeEqualParts;
import org.junit.Assert;
import org.junit.Test;

public class TestThreeEqualParts {

    private final ThreeEqualParts threeEqualParts;

    public TestThreeEqualParts() {
        threeEqualParts = new ThreeEqualParts();
    }

    @Test
    public void testOne() {
        int[] arr = {1, 0, 1, 0, 1};
        Assert.assertArrayEquals(new int[]{0, 3}, threeEqualParts.threeEqualParts(arr));
    }

    @Test
    public void testTwo() {
        int[] arr = {1, 1, 0, 1, 1};
        Assert.assertArrayEquals(new int[]{-1, -1}, threeEqualParts.threeEqualParts(arr));
    }

    @Test
    public void testThree() {
        int[] arr = {1, 1, 0, 0, 1};
        Assert.assertArrayEquals(new int[]{0, 2}, threeEqualParts.threeEqualParts(arr));
    }
}
