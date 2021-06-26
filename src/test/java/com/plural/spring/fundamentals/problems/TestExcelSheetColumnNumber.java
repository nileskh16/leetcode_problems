package com.plural.spring.fundamentals.problems;

import org.junit.Assert;
import org.junit.Test;

public class TestExcelSheetColumnNumber {

    private final ExcelSheetColumnNumber columnNumber;

    public TestExcelSheetColumnNumber() {
        columnNumber = new ExcelSheetColumnNumber();
    }

    @Test
    public void testOne() {
        Assert.assertEquals(703, columnNumber.titleToNumber("AAA"));
        Assert.assertEquals(28, columnNumber.titleToNumber("AB"));
        Assert.assertEquals(701, columnNumber.titleToNumber("ZY"));
        Assert.assertEquals(2147483647, columnNumber.titleToNumber("FXSHRXW"));
    }
}
