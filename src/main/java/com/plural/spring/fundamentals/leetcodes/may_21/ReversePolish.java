package com.plural.spring.fundamentals.leetcodes.may_21;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReversePolish {

    public int evalRPN(String[] tokens) {
        List<String> operators = Arrays.asList("+", "-", "*", "/");
        Stack<Integer> operands = new Stack<>();
        for (int i=0; i<tokens.length; i++) {
            String param = tokens[i];
            if (operators.contains(param)) {
                Integer op2 = operands.pop();
                Integer op1 = operands.pop();
                Integer result = calculateResult(param, op1, op2);
                operands.push(result);
            } else {
                Integer value = Integer.parseInt(param);
                operands.push(value);
            }
        }
        return operands.pop();
    }

    private int calculateResult(String operator, Integer op1, Integer op2) {
        int result = 0;
        switch (operator) {
            case "+":
                result = op1 + op2;
                break;
            case "-":
                result = op1 - op2;
                break;
            case "/":
                result = op1 / op2;
                break;
            case "*":
                result = op1 * op2;
                break;
        }
        return result;
    }
}
