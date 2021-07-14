package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.DecodeWaysII;
import org.junit.Assert;
import org.junit.Test;

public class TestDecodeWaysII {

    private final DecodeWaysII decodeWaysII;

    public TestDecodeWaysII() {
        decodeWaysII = new DecodeWaysII();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(9, decodeWaysII.numDecodings("*"));
        Assert.assertEquals(18, decodeWaysII.numDecodings("1*"));
        Assert.assertEquals(15, decodeWaysII.numDecodings("2*"));
    }
}
