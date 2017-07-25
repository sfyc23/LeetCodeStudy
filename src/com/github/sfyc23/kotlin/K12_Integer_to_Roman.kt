package com.github.sfyc23.kotlin

object K12_Integer_to_Roman {
    @JvmStatic fun main(args: Array<String>) {

    }

    fun intToRoman(num: Int): String {
        if (num < 1 || num > 3999) {
            throw IllegalArgumentException("please input num 1 in 3999")
        }
        val M = arrayOf("", "M", "MM", "MMM")
        val C = arrayOf("", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM")
        val X = arrayOf("", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC")
        val I = arrayOf("", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX")
        return M[num / 1000] + C[num % 1000 / 100] + X[num % 100 / 10] + I[num % 10]
    }
}
