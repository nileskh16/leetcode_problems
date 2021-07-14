package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.GreyCode;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestGreyCode {

    private final GreyCode greyCode;

    public TestGreyCode() {
        greyCode = new GreyCode();
    }

    @Test
    public void testOne() {
        List<Integer> result = greyCode.grayCode(2);
        Assert.assertArrayEquals(new Integer[]{0, 1, 3, 2}, result.toArray(new Integer[0]));
    }

    @Test
    public void testTwo() {
        List<Integer> result = greyCode.grayCode(1);
        Assert.assertArrayEquals(new Integer[]{0, 1}, result.toArray(new Integer[0]));
    }
}
