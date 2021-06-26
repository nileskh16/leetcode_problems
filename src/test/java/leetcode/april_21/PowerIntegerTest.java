package leetcode.april_21;

import com.plural.spring.fundamentals.leetcodes.april_21.PowerIntegers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PowerIntegerTest {
    private final PowerIntegers powerIntegers = new PowerIntegers();

    @Test
    public void testOne() {
        List<Integer> numbers = powerIntegers.getPowerIntegers(3, 2, 10);
        Collections.sort(numbers);
        assertThat(Arrays.asList(2, 3, 4, 5, 7, 9, 10), is(numbers));
    }

    @Test
    public void testTwo() {
        List<Integer> numbers = powerIntegers.getPowerIntegers(3, 5, 15);
        Collections.sort(numbers);
        assertThat(Arrays.asList(2, 4, 6, 8, 10, 14), is(numbers));
    }
}
