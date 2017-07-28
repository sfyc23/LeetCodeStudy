package com.github.sfyc23.kotlin


import java.util.ArrayList

/**
 * 131. Palindrome Partitioning
 *
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 *
 * Return all possible palindrome partitioning of s.
 *
 *
 * For example, given s = "aab",
 * Return
 *
 *
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
object K131_Palindrome_Partitioning {

    @JvmStatic fun main(args: Array<String>) {
        //        System.out.println(isPalindrome("caac"));
        println(partition("bbccd"))
    }

    fun partition(s: String): List<List<String>> {
        val list = ArrayList<List<String>>()
        backtrack(list, ArrayList<String>(), s, 0)
        return list
    }

    private fun backtrack(list: MutableList<List<String>>, tempList: MutableList<String>, s: String, start: Int) {
        val len = s.length
        if (len == start) {
            list.add(ArrayList(tempList))
            return
        }
        for (i in start..len - 1) {
            val sub = s.substring(start, i + 1)
            if (!isPalindrome(sub)) {
                continue
            }
            tempList.add(sub)
            backtrack(list, tempList, s, i + 1);
            tempList.removeAt(tempList.size - 1)
        }
    }

    private fun isPalindrome(s: String): Boolean {
        if (s.length == 1) {
            return true
        }

        var len = s.length - 1
        var i = 0
        while (i < len) {
            if (s[i++] != s[len--]) {
                return false
            }
        }
        return true
    }
}
