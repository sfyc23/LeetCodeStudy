package com.github.sfyc23.java;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class J3_Longest_Substring {
    public static void main(String[] args) {

        checkEquals("pwwkew", 3);
        checkEquals("bbbb", 1);
        checkEquals("abcabcbb", 3);
        checkEquals("abc", 3);
        checkEquals("11a2abc", 4);
        checkEquals("", 0);
        checkEquals("abba", 2);
    }

    public static void checkEquals(String s, int expected) {
        int output = lengthOfLongestSubstring(s);
        if (expected != output) {
            System.out.println();
            System.out.println("input:" + s + " , output:" + output + " , expected:" + expected);
            System.out.println();
        }
    }


    public static int lengthOfLongestSubstring(String s) {
        //如果有重复字符，
        int berIndex = 0;
        int maxLong = 0;
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (map.containsKey(cs[i])) {
                //如果有重复字符，则取两个重复字符第一个字符的后一个位置
                //比较与之前记录，取最大值。
                berIndex = Math.max(map.get(cs[i]) + 1, berIndex);
            }
            //当前位置减最后重复的字符序列+1 = 数量。
            maxLong = Math.max(i - berIndex + 1, maxLong);
//            System.out.println(i + ",maxLong=" + maxLong);
            map.put(cs[i], i);

        }

        return maxLong;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int berIndex = 0;
        int maxLong = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, length = s.length(); i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                berIndex = Math.max(map.get(s.charAt(i)) + 1, berIndex);
            }
            maxLong = Math.max(i - berIndex + 1, maxLong);
            map.put(s.charAt(i), i);
        }

        return maxLong;
    }
}
