package com.plural.spring.fundamentals.problems.strings;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int thresh = 64;
        int power = 1;
        int columnNumber = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            columnNumber += ((int) columnTitle.charAt(i) - thresh) * power;
            power *= 26;
        }
        return columnNumber;
    }
}
