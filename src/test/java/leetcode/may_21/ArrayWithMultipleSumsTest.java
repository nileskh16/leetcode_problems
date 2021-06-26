package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.TargetArrayWithMultipleSums;
import org.junit.Assert;
import org.junit.Test;

public class ArrayWithMultipleSumsTest {

    private final TargetArrayWithMultipleSums targetArray;

    public ArrayWithMultipleSumsTest() {
        targetArray = new TargetArrayWithMultipleSums();
    }

    @Test
    public void testOne() {
        int[] target = {9, 3, 5};
        Assert.assertTrue(targetArray.isPossible(target));
    }

    @Test
    public void testTwo() {
        int[] target = {1, 1, 1, 2};
        Assert.assertFalse(targetArray.isPossible(target));
    }

    @Test
    public void testThree() {
        int[] target = {8, 5};
        Assert.assertTrue(targetArray.isPossible(target));
    }

    @Test
    public void testFour() {
        int[] target = {9000, 30, 5};
        Assert.assertFalse(targetArray.isPossible(target));
    }

    @Test
    public void testFive() {
        int[] target = {1, 1000000000};
        Assert.assertTrue(targetArray.isPossible(target));
    }
}
