package com.github.sfyc23.kotlin

import java.util.ArrayList
import java.util.LinkedList

object K17_Letter_Combinations_of_a_Phone_Number {
    @JvmStatic fun main(args: Array<String>) {
        //        System.out.println(Character.getNumericValue('['));
        println(letterCombinations02("3456"))
    }

    fun letterCombinations02(digits: String?): List<String> {


        val ans = ArrayList<String>()
        if (digits == null || digits.trim { it <= ' ' }.length == 0) {
            return ans
        }
        val mapping = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        ans.add("")
        for (i in 0..digits.length - 1) {
            val x = Character.getNumericValue(digits[i])
            while (ans[0].length == i) {
                val t = ans[0]
                ans.removeAt(0)
                for (s in mapping[x].toCharArray())
                    ans.add(t + s)
            }
            println(ans)
        }
        return ans
        //        return strs;
    }

    fun letterCombinations(digits: String?): List<String> {


        val ans = LinkedList<String>()
        if (digits == null || digits.trim { it <= ' ' }.length == 0) {
            return ans
        }
        val mapping = arrayOf("0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        ans.add("")
        for (i in 0..digits.length - 1) {
            val x = Character.getNumericValue(digits[i])
            while (ans.peek().length == i) {
                val t = ans.remove()
                for (s in mapping[x].toCharArray())
                    ans.add(t + s)
            }
            println(ans)
        }
        return ans
        //        return strs;
    }


}
