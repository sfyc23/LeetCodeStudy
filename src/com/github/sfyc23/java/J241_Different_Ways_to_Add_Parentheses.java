package com.github.sfyc23.java;

import scala.Int;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 241. Different Ways to Add Parentheses
 * https://leetcode.com/problems/different-ways-to-add-parentheses/#/description
 * <p>
 * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
 * <p>
 * <p>
 * Example 1
 * Input: "2-1-1".
 * <p>
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * <p>
 * <p>
 * Example 2
 * Input: "2*3-4*5"
 * <p>
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 */
public class J241_Different_Ways_to_Add_Parentheses {

    public static void main(String[] args) {

        System.out.println(diffWaysToCompute("2*3-4*5"));
    }

    public static List<Integer> diffWaysToCompute(String input) {

        List<Integer> count = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String leftSub = input.substring(0, i);
                String rightSub = input.substring(i + 1);

                List<Integer> leftCount = diffWaysToCompute(leftSub);
                List<Integer> rightCount = diffWaysToCompute(rightSub);

                for (int left : leftCount) {
                    for (int right : rightCount) {
                        switch (c) {
                            case '+':
                                count.add(left + right);
                                break;
                            case '-':
                                count.add(left - right);
                                break;
                            case '*':
                                count.add(left * right);
                                break;
                        }
                    }
                }
            }
        }

        if (count.isEmpty()) {
            count.add(Integer.valueOf(input));
        }

        return count;
    }

    /**
     * 加减乘除,括号都可以计算;
     *
     * @param s
     * @return
     */
    public static int calculate(String s) {

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
                while (operation.get(operation.size() - 1) != ')') {
                    compute(operation, digital);
                }
                operation.pop();
            } else if (c == ')' || c == '*' || c == '/') {
                operation.push(c);
            } else if (c == '+' || c == '-') {
                while (!operation.isEmpty() && (
                        operation.get(operation.size() - 1) == '*'
                                || operation.get(operation.size() - 1) == '/')) {
                    compute(operation, digital);
                }
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


