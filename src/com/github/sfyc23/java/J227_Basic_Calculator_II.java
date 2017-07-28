package com.github.sfyc23.java;

import java.util.Stack;

/**
 * 227. Basic Calculator II
 * https://leetcode.com/problems/basic-calculator-ii/#/description
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 */

public class J227_Basic_Calculator_II {

    public static void main(String[] args) {

//        "14/3/2"
//        System.out.println(14 / 3);
        System.out.println(calculate("63+1337"));
    }


    public static int calculate(String s) {

        Stack<Integer> digital = new Stack<>();
        Stack<Character> operation = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {

            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                sb.insert(0, c);
                if (i == 0 || !Character.isDigit(s.charAt(i - 1))) {
                    digital.push(Integer.valueOf(sb.toString()));
                    //clear stringBuider
                    sb.setLength(0);
                }
            } else if (c == '+' || c == '-') {
                while (!operation.isEmpty() &&
                        (operation.get(operation.size() - 1) == '*' || operation.get(operation.size() - 1) == '/')) {
                    compute(operation, digital);
                }
                operation.push(c);
            } else if (c == '*' || c == '/') {
                operation.push(c);
            }
        }

        while (!operation.isEmpty()) {
            compute(operation, digital);
        }

        return digital.pop();
    }

    public static void compute(Stack<Character> operation, Stack<Integer> digital) {

        int left = digital.pop();
        int right = digital.pop();
        switch (operation.pop()) {
            case '+':
                digital.push(left + right);
                break;
            case '-':
                digital.push(left - right);
                break;
            case '*':
                digital.push(left * right);
                break;
            case '/':
                digital.push(left / right);
                break;
            default:
                break;
        }

    }
}
