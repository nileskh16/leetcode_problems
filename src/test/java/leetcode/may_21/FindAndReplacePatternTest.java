package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.FindAndReplacePattern;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FindAndReplacePatternTest {

    private final FindAndReplacePattern findAndReplacePattern;

    public FindAndReplacePatternTest() {
        findAndReplacePattern = new FindAndReplacePattern();
    }

    @Test
    public void testOne() {
        String[] sampleWords = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        String[] expectedArray = {"mee", "aqq"};
        List<String> answer = findAndReplacePattern.findAndReplacePattern(sampleWords, pattern);
        Assert.assertArrayEquals(expectedArray, answer.toArray());
    }

    @Test
    public void testTwo() {
        String[] sampleWords = {"fullifu", "dullidu", "fullifa", "nullinu", "calcium", "protein"};
        String pattern = "abccdab";
        String[] expectedArray = {"fullifu", "dullidu", "nullinu"};
        List<String> answer = findAndReplacePattern.findAndReplacePattern(sampleWords, pattern);
        Assert.assertArrayEquals(expectedArray, answer.toArray());
    }

    @Test
    public void testThree() {
        String[] sampleWords = {"a", "b", "c"};
        String pattern = "a";
        String[] expectedArray = {"a", "b", "c"};
        List<String> answer = findAndReplacePattern.findAndReplacePattern(sampleWords, pattern);
        Assert.assertArrayEquals(expectedArray, answer.toArray());
    }

    @Test
    public void testFour() {
        String[] sampleWords = {"aaaaaa", "bbbbbb", "cccccc"};
        String pattern = "dddddd";
        List<String> answer = findAndReplacePattern.findAndReplacePattern(sampleWords, pattern);
        Assert.assertArrayEquals(sampleWords, answer.toArray());
    }

    @Test
    public void testFive() {
        String[] sampleWords = {"abcdef", "ghijkl", "lmnopq", "rstuvv"};
        String pattern = "bcdefg";
        String[] expectedArray = {"abcdef", "ghijkl", "lmnopq"};
        List<String> answer = findAndReplacePattern.findAndReplacePattern(sampleWords, pattern);
        Assert.assertArrayEquals(expectedArray, answer.toArray());
    }

    @Test
    public void testSix() {
        String[] sampleWords = {"abcdcba", "fghihgf", "protein"};
        String pattern = "mnoponm";
        String[] expectedArray = {"abcdcba", "fghihgf",};
        List<String> answer = findAndReplacePattern.findAndReplacePattern(sampleWords, pattern);
        Assert.assertArrayEquals(expectedArray, answer.toArray());
    }

    @Test
    public void testSeven() {
        String[] sampleWords = {"moom", "noon", "soos"};
        String pattern = "aoob";
        String[] expectedArray = {};
        List<String> answer = findAndReplacePattern.findAndReplacePattern(sampleWords, pattern);
        Assert.assertArrayEquals(expectedArray, answer.toArray());
    }
}