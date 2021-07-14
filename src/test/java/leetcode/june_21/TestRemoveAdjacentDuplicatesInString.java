package leetcode.june_21;

import com.plural.spring.fundamentals.leetcodes.june_21.RemoveAdjacentDuplicatesInString;
import org.junit.Assert;
import org.junit.Test;

public class TestRemoveAdjacentDuplicatesInString {

    private final RemoveAdjacentDuplicatesInString duplicatesInString;

    public TestRemoveAdjacentDuplicatesInString() {
        duplicatesInString = new RemoveAdjacentDuplicatesInString();
    }

    @Test
    public void testOne() {
        Assert.assertEquals("ca", duplicatesInString.removeDuplicates("abbaca"));
        Assert.assertEquals("ay", duplicatesInString.removeDuplicates("azxxzy"));
        Assert.assertEquals("c", duplicatesInString.removeDuplicates("c"));
    }
}
