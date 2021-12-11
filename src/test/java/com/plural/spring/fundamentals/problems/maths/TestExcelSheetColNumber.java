package com.plural.spring.fundamentals.problems.maths;

import org.junit.Assert;
import org.junit.Test;

public class TestExcelSheetColNumber {

    private final ExcelSheetColNumber colNumber;

    public TestExcelSheetColNumber() {
        colNumber = new ExcelSheetColNumber();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(28, colNumber.titleToNumber("AB"));
        Assert.assertEquals(26, colNumber.titleToNumber("Z"));
        Assert.assertEquals(677, colNumber.titleToNumber("ZA"));
        Assert.assertEquals(701, colNumber.titleToNumber("ZY"));
        Assert.assertEquals(2147483647, colNumber.titleToNumber("FXSHRXW"));
    }
}
