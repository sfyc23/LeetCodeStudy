package com.github.sfyc23.java;

/**
 * 41. First Missing Positive
 * <p>
 * <p>
 * https://leetcode.com/problems/first-missing-positive/tabs/description
 * <p>
 * Given an unsorted integer array, find the first missing positive integer.
 * <p>
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * <p>
 * Your algorithm should run in O(n) time and uses constant space.
 * <p>
 * <p>
 * //看不懂题目
 */
public class J41_First_Missing_Positive {

    public static void main(String[] args) {
        System.out.println(firstMissingPositive02(new int[]{2}));
        System.out.println(firstMissingPositive02(new int[]{1}));
        System.out.println(firstMissingPositive02(new int[]{0}));
        System.out.println(firstMissingPositive02(new int[]{-1}));

    }

    public static int firstMissingPositive(int[] nums) {
//        int i = 0;
        int len = nums.length;
        if (len == 0) {
            return 1;
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] < 0) {
                return i + 1;
            }
        }
        return len;
    }

    public static int firstMissingPositive02(int[] A) {
        int i = 0;
        while (i < A.length) {
            if (A[i] == i + 1 || A[i] <= 0 || A[i] > A.length){
                i++;
            } else if (A[A[i] - 1] != A[i]){
                swap(A, i, A[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < A.length && A[i] == i + 1){
            i++;
        }
        return i + 1;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
