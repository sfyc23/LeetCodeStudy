package com.github.sfyc23.java;

/**
 * 注意点，int 越界时，-x不起作用。
 */
public class J7_Reverse_Integer {
    public static void main(String[] args) {
        System.out.println((int)Integer.MIN_VALUE);
        System.out.println(reverse01(1534236469));
    }

    public static int reverse01(int x) {
        boolean isAds = false;

        long xx = x;
        if (xx < 0) {
            isAds = true;
            xx = -xx;
        }
        StringBuffer sb = new StringBuffer();
        sb.append(xx);
        sb.reverse();
//        System.out.println(sb.toString());
        Long ll = Long.valueOf(sb.toString());
        if (isAds) {
            ll = -ll;
        }
        if (ll < Integer.MAX_VALUE && ll > Integer.MIN_VALUE) {
            return ll.intValue();
        }
        return 0;
    }
}




