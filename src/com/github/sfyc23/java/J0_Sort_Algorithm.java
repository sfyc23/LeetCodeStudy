package com.github.sfyc23.java;

import java.util.Arrays;

/**
 * 8 种排序方法
 */
public class J0_Sort_Algorithm {
    public static void main(String[] args) {
        int[] a = {2, 4, 6, 1, 3, 8, 9, 7, 5};
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 1.直接插入排序：
     *
     * @param a
     * @return
     */
    public static int[] insertionSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        return a;
    }


    /**
     * 2.折半插入排序
     * @param a
     * @return
     */
    public static int[] binaryInsertSort(int a[]) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int low = 0;
            int high = i - 1;

            while (low <= high) {
                int mid = (low + high) / 2;
                if (temp < a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            for (int j = i; j >= low + 1; j--) {
                a[j] = a[j - 1];
            }
            a[low] = temp;
        }
        return a;
    }

}
