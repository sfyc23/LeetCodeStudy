package com.github.sfyc23.java;

/*
14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/#/description
Write a function to find the longest common prefix string amongst an array of strings.
 */
public class J14_Longest_Common_Prefix {
    public static void main(String[] args) {
        String[] str = {"a"};
        longestCommonPrefix02(str);
    }


    /*
    暴力轮询,从第一个元素的第一个字符开始,Vertical scanning
    */
    public static String longestCommonPrefix02(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefixOne = strs[0];
        String prefix = "";
        for (int i = 0; i < prefixOne.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                prefix = prefixOne.substring(0, i + 1);
                if (strs[j].indexOf(prefix) != 0) {
                    return prefixOne.substring(0, i);
                }

            }
        }
        return prefix;
    }

    /*
    暴力轮询,从第一个元素开始,Horizontal scanning
     */
    public static String longestCommonPrefix01(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];

        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

}
