package com.github.sfyc23.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/#/description
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * 罗马数字就有下面七个基本符号：Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、L（50）、C（100）、D（500）、M（1000）。
 * <p>
 * 记数方法：
 * (1)相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
 * (2)小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
 * (3)小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
 * (4)正常使用时连写的数字重复不得超过三次。（表盘上的四点钟--“IIII”，例外。）
 * (5)在一个数的上面画一条横线，表示这个数扩大1000 倍。
 */
public class J13_Roman_to_Integer {
    public static void main(String[] args) {
        System.out.println(intToRoman("MMMDLXXXVI"));
    }

    public static int intToRoman(String s) {
        int num = 0;
        Map<Character, Integer> mapRoman = new HashMap<>();
        mapRoman.put('M', 1000);
        mapRoman.put('D', 500);
        mapRoman.put('C', 100);
        mapRoman.put('L', 50);
        mapRoman.put('X', 10);
        mapRoman.put('V', 5);
        mapRoman.put('I', 1);

        for (int i = 0; i < s.length() - 1; i++) {
            if (mapRoman.get(s.charAt(i)) < mapRoman.get(s.charAt(i + 1))) {
                num -= mapRoman.get(s.charAt(i));
            } else {
                num += mapRoman.get(s.charAt(i));
            }
        }
        return num + mapRoman.get(s.charAt(s.length() - 1));
    }
}
