package com.github.sfyc23.java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * 136. Single Number
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class J136_Single_Number {

    public static void main(String[] args) {
        System.out.println(0 ^ 5 ^ 4 ^ 5);
    }


    /**
     * 按位异或方法
     * 原理
     * N == 0^N;
     * 0 == N^N;
     * @param nums
     * @return
     */
    public static int singleNumber02(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;

        }
        return result;
    }

    /**
     * hash 取值。
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            } else {
                hashSet.add(nums[i]);
            }
        }

        return hashSet.iterator().next();


    }
}
