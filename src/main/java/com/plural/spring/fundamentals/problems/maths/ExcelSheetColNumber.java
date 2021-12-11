package com.plural.spring.fundamentals.problems.maths;

public class ExcelSheetColNumber {

    public int titleToNumber(String columnTitle) {
        int number = 0;
        int colLen = columnTitle.length() - 1;
        for (int i = colLen; i >= 0; i--) {
            number += (columnTitle.charAt(i) - 64) * (int) Math.pow(26, colLen - i);
        }
        return number;
    }
}
