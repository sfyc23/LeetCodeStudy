package com.github.sfyc23.java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/#/description
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class J17_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
//        System.out.println(Character.getNumericValue('['));
        System.out.println(letterCombinations("3456"));
    }

    public static List<String> letterCombinations02(String digits) {


        List<String> ans = new ArrayList<>();
        if (digits == null || digits.trim().length() == 0) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.get(0).length() == i) {
                String t = ans.get(0);
                ans.remove(0);
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
            System.out.println(ans);
        }
        return ans;
//        return strs;
    }

    public static List<String> letterCombinations(String digits) {


        LinkedList<String> ans = new LinkedList<>();
        if (digits == null || digits.trim().length() == 0) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
            System.out.println(ans);
        }
        return ans;
//        return strs;
    }


}
