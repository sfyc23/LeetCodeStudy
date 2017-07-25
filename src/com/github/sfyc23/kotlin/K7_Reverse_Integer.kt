package com.github.sfyc23.kotlin

object K7_Reverse_Integer {
    @JvmStatic fun main(args: Array<String>) {

        println(reverse01(1534236469))
    }

    fun reverse01(x: Int): Int {
        var isAds = false

        var xx = x.toLong()
        if (xx < 0) {
            isAds = true
            xx = Math.abs(xx)
        }
        var ll = xx.toString().reversed().toLong()
        if (isAds) {
            ll = -ll
        }
        if (ll < Integer.MAX_VALUE && ll > Integer.MIN_VALUE) {
            return ll.toInt()
        }
        return 0
    }
}




