package leetcode.august_21;

import com.plural.spring.fundamentals.leetcodes.august_21.PalindromeSubstrings;
import org.junit.Assert;
import org.junit.Test;

public class TestPalindromeSubstrings {

    private final PalindromeSubstrings substrings;

    public TestPalindromeSubstrings() {
        substrings = new PalindromeSubstrings();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(0, substrings.minCut(""));
        Assert.assertEquals(0, substrings.minCut("a"));
        Assert.assertEquals(1, substrings.minCut("aab"));
        Assert.assertEquals(1, substrings.minCut("ab"));
        Assert.assertEquals(2, substrings.minCut("aaacccbbb"));
        Assert.assertEquals(3, substrings.minCut("abacccbcd"));
    }
}
