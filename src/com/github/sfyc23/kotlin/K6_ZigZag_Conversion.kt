package com.github.sfyc23.kotlin

fun convert02(s: String, numRows: Int): String {
    val c = s.toCharArray()
    val len = c.size
    val sb = arrayOf(StringBuffer(), StringBuffer(), StringBuffer())

    var i = 0
    while (i < len) {
        for (idx in 0..numRows) {
            if (i < len) {
                sb[idx].append(c[i++])
            }
        }

        for (idx in numRows - 2 downTo 1) {
            if (i < len) {
                sb[idx].append(c[i++])
            }
        }

    }

    for (i in 1..sb.lastIndex) {
        sb[0].append(sb[i])
    }

    return sb[0].toString()
}