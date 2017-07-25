package com.github.sfyc23.kotlin

import java.util.HashMap

fun main(args: Array<String>) {

}

fun lengthOfLongestSubstring(s: String): Int {
    var berIndex = 0
    var maxLong = 0
    s.reversed()
    val map = HashMap<Char, Int>()
    for (i in 0..s.length) {
        if (map.containsKey(s[i])) {
            berIndex = Math.max(map[s[i]]!! + 1, berIndex)
        }
        maxLong = Math.max(i - berIndex + 1, maxLong)
        map.put(s[i], i)
    }
    return maxLong
}