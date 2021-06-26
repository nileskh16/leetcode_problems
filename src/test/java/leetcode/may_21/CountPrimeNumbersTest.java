package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.CountPrimes;
import org.junit.Assert;
import org.junit.Test;

public class CountPrimeNumbersTest {

    private final CountPrimes countPrimes;

    public CountPrimeNumbersTest() {
        countPrimes = new CountPrimes();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(4, countPrimes.getCount(10));
    }

    @Test
    public void testTwo() {
        Assert.assertEquals(0, countPrimes.getCount(0));
    }

    @Test
    public void testThree() {
        Assert.assertEquals(0, countPrimes.getCount(1));
    }

    @Test
    public void testFour() {
        Assert.assertEquals(25, countPrimes.getCount(100));
    }

    @Test
    public void testFive() {
        Assert.assertEquals(168, countPrimes.getCount(1000));
    }

    @Test
    public void testSix() {
        Assert.assertEquals(50847534, countPrimes.getCount(1000000000));
    }
}
