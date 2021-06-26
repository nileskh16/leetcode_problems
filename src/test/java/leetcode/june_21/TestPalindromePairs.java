package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.PalindromePairs;
import org.junit.Test;

import java.util.List;

public class TestPalindromePairs {

    private final PalindromePairs palindromePairs;

    public TestPalindromePairs() {
        palindromePairs = new PalindromePairs();
    }

    @Test
    public void testOne() {
        String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
        List<List<Integer>> result = palindromePairs.palindromePairs(words);
    }
}
