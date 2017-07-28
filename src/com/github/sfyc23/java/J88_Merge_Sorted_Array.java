package com.github.sfyc23.java;

import java.util.Arrays;

public class J88_Merge_Sorted_Array {

    public static void main(String[] args) {

        merge2(
                new int[]{1, 2, 4, 5, 6, 0},
                3,
                new int[]{2, 5, 7},
                3
        );
        merge3(
                new int[]{1, 2, 4, 5, 6, 0},
                3,
                new int[]{2, 5, 7},
                3
        );
    }

    //白痴示做法
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }

        for (int i = 0; i < n; i++) {
            nums[i + m] = nums2[i];
        }
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            nums1[i] = nums[i];
        }
    }

    //倒序比较法,最简
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {

        int length = m + n;

        while (n > 0) {
            nums1[--length] = (m == 0 || nums1[m - 1] < nums2[n - 1]) ? nums2[--n] : nums1[--m];
        }

        System.out.println(Arrays.toString(nums1));
    }

    //拆半插入
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        for (int i = 0; i < n; i++) {
            int length = m + i;
            int target = nums2[i];
            left = insertFind(nums1, left, length, target);
            System.out.println(Arrays.toString(nums1));
        }
    }

    public static int insertFind(int[] nums1, int left, int length, int target) {
        int right = length - 1;
        while (left <= right) {
            int half = (left + right) / 2;
            if (target == nums1[half]) {
                left = half;
                insert(nums1, left, length, target);
                return left;
            } else if (nums1[half] < target) {
                left = half + 1;
            } else {
                right = half - 1;
            }
        }
        insert(nums1, left, length, target);
        return left;
    }

    public static void insert(int[] nums1, int position, int length, int target) {

        for (int i = length; i > position; i--) {
            nums1[i] = nums1[i - 1];
        }
        nums1[position] = target;
    }


}
