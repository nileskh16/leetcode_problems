package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.SuperPalindromes;
import org.junit.Assert;
import org.junit.Test;

public class SuperPalindromeTest {

    private final SuperPalindromes palindromes;

    public SuperPalindromeTest() {
        palindromes = new SuperPalindromes();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(4, palindromes.findSuperPalindromes("4", "1000"));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(1, palindromes.findSuperPalindromes("1", "2"));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(21, palindromes.findSuperPalindromes("1", "1000000000"));
    }
}
