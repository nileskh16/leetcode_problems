package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.LowerCase;
import org.junit.Assert;
import org.junit.Test;

public class TestLowerClass {
    private final LowerCase lowerCase;

    public TestLowerClass() {
        lowerCase = new LowerCase();
    }

    @Test
    public void testOne() {
        Assert.assertEquals("hello", lowerCase.toLowerCase("Hello"));
        Assert.assertEquals("lovely", lowerCase.toLowerCase("LOVELY"));
        Assert.assertEquals("obsolete", lowerCase.toLowerCase("OBSOLETE"));
    }
}
