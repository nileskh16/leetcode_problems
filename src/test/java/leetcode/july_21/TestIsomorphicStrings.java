package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.IsomorphicStrings;
import org.junit.Assert;
import org.junit.Test;

public class TestIsomorphicStrings {
    private final IsomorphicStrings isoStrings;

    public TestIsomorphicStrings() {
        isoStrings = new IsomorphicStrings();
    }

    @Test
    public void testOne() {
        Assert.assertTrue(isoStrings.isIsomorphic("egg", "add"));
        Assert.assertTrue(isoStrings.isIsomorphic("paper", "title"));
        Assert.assertFalse(isoStrings.isIsomorphic("foo", "bar"));
    }
}