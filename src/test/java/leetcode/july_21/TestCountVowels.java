package leetcode.july_21;

import com.plural.spring.fundamentals.leetcodes.july_21.CountVowelsPermutation;
import org.junit.Assert;
import org.junit.Test;

public class TestCountVowels {

    private final CountVowelsPermutation vowelsPermutation;

    public TestCountVowels() {
        vowelsPermutation = new CountVowelsPermutation();
    }

    @Test
    public void test() {
        Assert.assertEquals(5, vowelsPermutation.countVowelPermutation(1));
        Assert.assertEquals(10, vowelsPermutation.countVowelPermutation(2));
        Assert.assertEquals(19, vowelsPermutation.countVowelPermutation(3));
    }
}
