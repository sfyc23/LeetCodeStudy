package com.github.sfyc23.java;

import java.util.List;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/#/description
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * <p>
 * 给定一个仅包含字符'（'，'）'，'{'，'}'，'['和']'的字符串，确定输入字符串是否有效。
 * <p>
 * 括号必须以正确的顺序关闭，“（）”和“（）[] {}”都是有效的，但“（]”和“（[）]”不是。
 * ( = 40 { =123 [ = 91
 * ) = 41 } =125 ] = 93
 */
public class J20_Valid_Parentheses {
    public static void main(String[] args) {
//        System.out.println(isValid("([])[]"));
//        System.out.println(isValid("{}{}()[]"));

        System.out.println(isValid2("[[]]()()"));
        System.out.println(isValid2("[(])(())"));

    }

    /**
     * 使用 stack 后入先出（LIFO）集合
     *
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValid2(String s) {
        List<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.add(')');
                    break;
                case '{':
                    stack.add('}');
                    break;
                case '[':
                    stack.add(']');
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char cc = stack.get(stack.size() - 1);
                    if (cc != c) {
                        return false;
                    }
                    stack.remove(stack.size() - 1);
                    break;
            }
        }
        return stack.isEmpty();
    }


}
