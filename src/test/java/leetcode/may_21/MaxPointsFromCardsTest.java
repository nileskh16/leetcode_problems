package leetcode.may_21;

import com.plural.spring.fundamentals.leetcodes.may_21.MaxPointsFromCards;
import org.junit.Assert;
import org.junit.Test;

public class MaxPointsFromCardsTest {

    private final MaxPointsFromCards maxPointsFromCards;

    public MaxPointsFromCardsTest() {
        maxPointsFromCards = new MaxPointsFromCards();
    }

    @Test
    public void testOne() {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        Assert.assertEquals(12, maxPointsFromCards.drawMaxPointsFromCards(cardPoints, 3));
    }

    @Test
    public void testTwo() {
        int[] cardPoints = {2, 2, 2};
        Assert.assertEquals(4, maxPointsFromCards.drawMaxPointsFromCards(cardPoints, 2));
    }

    @Test
    public void testThree() {
        int[] cardPoints = {9, 7, 7, 9, 7, 7, 9};
        Assert.assertEquals(55, maxPointsFromCards.drawMaxPointsFromCards(cardPoints, 7));
    }

    @Test
    public void testFour() {
        int[] cardPoints = {9, 6, 3, 4, 8, 7};
        Assert.assertEquals(24, maxPointsFromCards.drawMaxPointsFromCards(cardPoints, 3));
    }

    @Test
    public void testFive() {
        int[] cardPoints = {11, 49, 100, 20, 86, 29, 72};
        Assert.assertEquals(232, maxPointsFromCards.drawMaxPointsFromCards(cardPoints, 4));
    }

    @Test
    public void testSix() {
        int[] cardPoints = {1, 79, 80, 1, 1, 1, 200, 1};
        Assert.assertEquals(202, maxPointsFromCards.drawMaxPointsFromCards(cardPoints, 3));
    }
}
