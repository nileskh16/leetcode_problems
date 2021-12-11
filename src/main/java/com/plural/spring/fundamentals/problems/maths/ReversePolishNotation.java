package com.plural.spring.fundamentals.problems.maths;

import java.util.Deque;
import java.util.LinkedList;

public class ReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Deque<Integer> operands = new LinkedList<>();
        for (String token : tokens) {
            int num = 0;
            if (token.length() == 1) {
                char ch = token.charAt(0);
                if (ch < 48 || ch > 57) {
                   num =  calculate(ch, operands.pop(), operands.pop());
                } else num = Integer.parseInt(token);
            } else {
                num = Integer.parseInt(token);
            }
            operands.push(num);
        }
        return operands.pop();
    }

    private int calculate(char operator, int op1, int op2) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '/':
                return op1 != 0 ? op2 / op1 : 0;
            case '*':
                return op1 * op2;
            default:
                return 0;
        }
    }
}
