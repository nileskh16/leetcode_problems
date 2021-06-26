package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.ValidNumber;
import org.junit.Assert;
import org.junit.Test;

public class ValidNumberTest {
    private final ValidNumber validNumber;

    public ValidNumberTest() {
        validNumber = new ValidNumber();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(validNumber.isNumberValid("2"));
        Assert.assertTrue(validNumber.isNumberValid("0089"));
        Assert.assertTrue(validNumber.isNumberValid("+3.14"));
        Assert.assertTrue(validNumber.isNumberValid("3e+7"));
        Assert.assertTrue(validNumber.isNumberValid("53.5e93"));
        Assert.assertTrue(validNumber.isNumberValid("-7"));
        Assert.assertTrue(validNumber.isNumberValid("-123.456e789"));
    }
}
