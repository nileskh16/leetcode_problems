package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.DeleteOnStrings;
import org.junit.Assert;
import org.junit.Test;

public class DeleteOnStringTest {

    private final DeleteOnStrings deleteOnStrings;

    public DeleteOnStringTest() {
        deleteOnStrings = new DeleteOnStrings();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(2, deleteOnStrings.minDistance("sea", "eat"));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(4, deleteOnStrings.minDistance("leetcode", "etco"));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(0, deleteOnStrings.minDistance("sea", "sea"));
    }

    @Test
    public void testFour() {
        Assert.assertEquals(6, deleteOnStrings.minDistance("four", "five"));
    }

    @Test
    public void testFive() {
        Assert.assertEquals(2, deleteOnStrings.minDistance("a", "b"));
    }

    @Test
    public void testSix() {
        Assert.assertEquals(3, deleteOnStrings.minDistance("park", "spake"));
    }
}
