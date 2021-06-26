package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.InterleavingString;
import org.junit.Assert;
import org.junit.Test;

public class TestInterleavingString {

    private final InterleavingString interleavingString;

    public TestInterleavingString() {
        interleavingString = new InterleavingString();
    }

    @Test
    public void testOne() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        Assert.assertTrue(interleavingString.isInterleave(s1, s2, s3));
    }

    @Test
    public void testTwo() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        Assert.assertFalse(interleavingString.isInterleave(s1, s2, s3));
    }

    @Test
    public void testThree() {
        String s1 = "";
        String s2 = "";
        String s3 = "";
        Assert.assertTrue(interleavingString.isInterleave(s1, s2, s3));
    }
}
