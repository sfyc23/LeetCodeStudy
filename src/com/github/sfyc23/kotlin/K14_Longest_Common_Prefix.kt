package com.github.sfyc23.kotlin

/*
14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/#/description
Write a function to find the longest common prefix string amongst an array of strings.
 */
object K14_Longest_Common_Prefix {
    @JvmStatic fun main(args: Array<String>) {
        val str = arrayOf("a")
        longestCommonPrefix02(str)
    }


    /*
    暴力轮询,从第一个元素的第一个字符开始,Vertical scanning
    */
    fun longestCommonPrefix02(strs: Array<String>?): String {
        if (strs == null || strs.size == 0) {
            return ""
        }
        val prefixOne = strs[0]
        var prefix = ""
        for (i in 0..prefixOne.length - 1) {

            strs.forEach {
                prefix = prefixOne.substring(0, i + 1)
                if (it.indexOf(prefix) != 0) {
                    return prefixOne.substring(0, i)
                }
            }
        }
        return prefix
    }

    /*
    暴力轮询,从第一个元素开始,Horizontal scanning
     */
    fun longestCommonPrefix01(strs: Array<String>?): String {
        if (strs == null || strs.size == 0) {
            return ""
        }
        var prefix = strs[0]

        for (i in strs.indices) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length - 1)
                if (prefix.isEmpty()) {
                    return ""
                }
            }
        }
        return prefix
    }

}
