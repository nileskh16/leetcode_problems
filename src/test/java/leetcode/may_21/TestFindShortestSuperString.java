package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.FindShortestSuperString;
import org.junit.Assert;
import org.junit.Test;

public class TestFindShortestSuperString {

    private final FindShortestSuperString findShortestSuperString;

    public TestFindShortestSuperString() {
        findShortestSuperString = new FindShortestSuperString();
    }

    @Test
    public void testOne() {
        String[] words = {"alex", "loves", "leetcode"};
        Assert.assertEquals("alexlovesleetcode", findShortestSuperString.shortestSuperString(words));
    }

    @Test
    public void testTwo() {
        String[] words = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
        Assert.assertEquals("gctaagttcatgcatc", findShortestSuperString.shortestSuperString(words));
    }
}
