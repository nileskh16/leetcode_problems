package com.plural.spring.fundamentals.leetcodes.august_21;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ComplexNumberMultiplication {

    public String complexNumberMultiply(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int a, b, c, d;
        Pattern pattern = Pattern.compile("^(\\-?\\d+)\\+(\\-?\\d+)i$");
        Matcher matcher = pattern.matcher(num1);
        a = Integer.parseInt(matcher.group(1));
        b = Integer.parseInt(matcher.group(2));
        matcher = pattern.matcher(num2);
        c = Integer.parseInt(matcher.group());
        d = Integer.parseInt(matcher.group());
        sb.append((a*c) - (b*d)).append("+").append((a*d) + (b*c)).append("i");
        return sb.toString();
    }
}
