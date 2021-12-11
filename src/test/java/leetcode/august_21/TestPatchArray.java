package leetcode.august_21;

import com.plural.spring.fundamentals.leetcodes.august_21.PatchArray;
import org.junit.Assert;
import org.junit.Test;

public class TestPatchArray {

    private final PatchArray patchArray;

    public TestPatchArray() {
        patchArray = new PatchArray();
    }

    @Test
    public void testOne() {
        int[] nums = {1, 5, 10};
        Assert.assertEquals(2, patchArray.minPatches(nums, 20));
    }
}
