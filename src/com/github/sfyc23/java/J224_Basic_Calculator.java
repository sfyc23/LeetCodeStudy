package com.github.sfyc23.java;

import scala.Int;

import java.util.Stack;

/**
 * 224. Basic Calculator
 * https://leetcode.com/problems/basic-calculator/#/description
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * <p>
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 * <p>
 * You may assume that the given expression is always valid.
 * <p>
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * <p>
 * 括号并不影响计算
 * <p>
 * 假设吧，只有单个数字。（证实后，并非如此）
 * <p>
 * 括号前是减号  3-((5-6)-1)
 * 有多个括号。(3-(2-(5-(9-(4)))))
 * 括号里只有数字 (3-(2-(5-(9-(4)))))
 * 并非个位数
 */
public class J224_Basic_Calculator {
    public static void main(String[] args) {
//        System.out.println(calculate("3-((5-6)-1)"));
//        System.out.println(calculate02("3-((5-6)-1)"));
//
//
//        System.out.println(calculate("(3-(2-(5-(9-(4)))))"));
//        System.out.println(calculate02("(3-(2-(5-(9-(4)))))"));

        System.out.println(calculate("7463847412"));
//        System.out.println(calculate02("7463847412"));

        Long ll = 7463847412L;
        System.out.println(ll.intValue());
    }

    //3-((5-6)-1)
    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int number = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                //we push the result first, then sign;
                stack.push(result);
                stack.push(sign);
                //reset the sign and result for the value in the parenthesis
                sign = 1;
                result = 0;
            } else if (c == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();    //stack.pop() is the sign before the parenthesis
                result += stack.pop();   //stack.pop() now is the result calculated before the parenthesis

            }
        }
        if (number != 0) result += sign * number;
        return result;
    }


    //(3-(2-(5-(9-(4)))))
    // 3-((5-6)-1)
    public static int calculate02(String s) {

        Stack<Integer> digital = new Stack<>();
        Stack<Character> operation = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                sb.insert(0, c);
                if (i == 0 || !Character.isDigit(s.charAt(i - 1))) {

                    digital.push(Long.valueOf(sb.toString()).intValue());
                    sb.setLength(0);
                }
            } else if (c == '(') {
                while (operation.get(operation.size()-1) != ')') {
                    compute(operation, digital);
                }
                operation.pop();
            } else if (c == '+' || c == '-' || c == ')') {
                operation.push(c);
            }
        }

        while (!operation.isEmpty()){
            compute(operation,digital);
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
            default:
                break;
        }
    }

}
