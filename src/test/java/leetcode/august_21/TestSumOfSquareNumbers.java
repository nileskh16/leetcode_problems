package leetcode.august_21;

import com.plural.spring.fundamentals.leetcodes.august_21.SumOfSquareNumbers;
import org.junit.Assert;
import org.junit.Test;

public class TestSumOfSquareNumbers {

    private final SumOfSquareNumbers sumOfSquareNumbers;

    public TestSumOfSquareNumbers() {
        sumOfSquareNumbers = new SumOfSquareNumbers();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(sumOfSquareNumbers.judgeSquareSum(5));
        Assert.assertTrue(sumOfSquareNumbers.judgeSquareSum(4));
        Assert.assertTrue(sumOfSquareNumbers.judgeSquareSum(2));
        Assert.assertTrue(sumOfSquareNumbers.judgeSquareSum(1));
        Assert.assertTrue(sumOfSquareNumbers.judgeSquareSum(0));
        Assert.assertFalse(sumOfSquareNumbers.judgeSquareSum(3));
    }
}
