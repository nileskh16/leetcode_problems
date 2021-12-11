package leetcode.august_21;

import com.plural.spring.fundamentals.leetcodes.august_21.ComplexNumberMultiplication;
import org.junit.Assert;
import org.junit.Test;

public class TestComplexNumberMultiplications {

    private final ComplexNumberMultiplication numberMultiplication;

    public TestComplexNumberMultiplications() {
        numberMultiplication = new ComplexNumberMultiplication();
    }

    @Test
    public void testOne() {
        String num1 = "1+1i", num2 = "1+1i";
        Assert.assertEquals("0+2i", numberMultiplication.complexNumberMultiply(num1, num2));
    }
}
