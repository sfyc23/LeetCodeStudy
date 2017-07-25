package com.github.sfyc23.kotlin

import java.util.HashMap

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/#/description
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 *
 * 罗马数字就有下面七个基本符号：Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、L（50）、C（100）、D（500）、M（1000）。
 *
 *
 * 记数方法：
 * (1)相同的数字连写，所表示的数等于这些数字相加得到的数，如：Ⅲ = 3；
 * (2)小的数字在大的数字的右边，所表示的数等于这些数字相加得到的数， 如：Ⅷ = 8；Ⅻ = 12；
 * (3)小的数字，（限于Ⅰ、X 和C）在大的数字的左边，所表示的数等于大数减小数得到的数，如：Ⅳ= 4；Ⅸ= 9；
 * (4)正常使用时连写的数字重复不得超过三次。（表盘上的四点钟--“IIII”，例外。）
 * (5)在一个数的上面画一条横线，表示这个数扩大1000 倍。
 */
object K13_Roman_to_Integer {
    @JvmStatic fun main(args: Array<String>) {
        println(intToRoman("MMMDLXXXVI"))
    }

    fun intToRoman(s: String): Int {
        var num = 0
        val mapRoman = hashMapOf('M' to 1000,'D' to 500,'C' to 100,'L' to 50,'X' to 10,'V' to 5,'I' to 1)
        for (i in 0..s.length - 1 - 1) {
            if (mapRoman[s[i]]!! < mapRoman[s[i + 1]]!!) {
                num -= mapRoman[s[i]]!!
            } else {
                num += mapRoman[s[i]]!!
            }
        }
        return num + mapRoman[s[s.length - 1]]!!
    }
}