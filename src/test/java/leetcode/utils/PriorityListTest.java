package leetcode.utils;

import com.plural.spring.fundamentals.utils.PriorityList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class PriorityListTest {

    private PriorityList priorityList;

    @Before
    public void initSetup() {
        priorityList = new PriorityList();
    }

    @Test
    public void testOne() {
        priorityList.add(64);
        priorityList.add(45);
        priorityList.add(21);
        priorityList.add(99);
        priorityList.add(7);
        Assert.assertEquals(7, priorityList.poll());
        Assert.assertEquals(21, priorityList.poll());
        Assert.assertEquals(45, priorityList.poll());
        Assert.assertEquals(64, priorityList.poll());
        Assert.assertEquals(99, priorityList.poll());
        Assert.assertThrows(NoSuchElementException.class, () -> {
            priorityList.poll();
        });
    }
}
