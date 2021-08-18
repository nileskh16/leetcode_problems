package leetcode.august_21;

import com.plural.spring.fundamentals.leetcodes.august_21.AddStrings;
import org.junit.Assert;
import org.junit.Test;

public class TestAddStrings {

    private final AddStrings addStrings;

    public TestAddStrings() {
        addStrings = new AddStrings();
    }

    @Test
    public void testOne() {
        Assert.assertEquals("132", addStrings.addStrings("11", "121"));
        Assert.assertEquals("132", addStrings.addStrings("16", "116"));
        Assert.assertEquals("533", addStrings.addStrings("456", "77"));
        Assert.assertEquals("0", addStrings.addStrings("0", "0"));
        Assert.assertEquals("10", addStrings.addStrings("1", "9"));
    }
}
