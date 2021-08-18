package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.NonNegativeIntegersWithoutTwoOnes;
import org.junit.Assert;
import org.junit.Test;

public class TestNonNegativeIntegers {

    private final NonNegativeIntegersWithoutTwoOnes withoutTwoOnes;

    public TestNonNegativeIntegers() {
        withoutTwoOnes = new NonNegativeIntegersWithoutTwoOnes();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(5, withoutTwoOnes.findIntegers(5));
        Assert.assertEquals(2, withoutTwoOnes.findIntegers(1));
        Assert.assertEquals(3, withoutTwoOnes.findIntegers(2));
        Assert.assertEquals(9, withoutTwoOnes.findIntegers(16));
    }
}
