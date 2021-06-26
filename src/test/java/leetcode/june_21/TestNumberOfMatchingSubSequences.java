package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.NumberOfMatchingSubsequences;
import org.junit.Assert;
import org.junit.Test;

public class TestNumberOfMatchingSubSequences {

    private final NumberOfMatchingSubsequences subsequences;

    public TestNumberOfMatchingSubSequences() {
        subsequences = new NumberOfMatchingSubsequences();
    }

    @Test
    public void testOne() {
        String[] words = {"a", "bb", "acd", "ace"};
        String parent = "abcde";
        Assert.assertEquals(3, subsequences.numMatchingSubseq(parent, words));
    }

    @Test
    public void testTwo() {
        String[] words = {"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"};
        String parent = "dsahjpjauf";
        Assert.assertEquals(2, subsequences.numMatchingSubseq(parent, words));
    }
}
