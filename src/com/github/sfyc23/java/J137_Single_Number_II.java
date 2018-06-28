package com.github.sfyc23.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 137. Single Number II
 * Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class J137_Single_Number_II {

    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 4, 3, 1, 1, 3, 2, 4, 4};
        int[] nums = new int[]{3, 3, 3};
//        System.out.println(singleNumber02(nums));
        System.out.println(4 & ~5 & ~5);
        System.out.println(4 ^ 5 ^ 5);

    }

    /**
     * 反运算符～
     * 与运算符&
     * 第一次出现时，将其保存于 ones。
     * 第二次出现时，清除 ones 中的数据，但将其保存于 twos 中，以供稍后检查。
     * 第三次出现时，尝试保存 ones 中，但是清除 ones,twos 中的数据。
     *
     * @return
     */
    public static int singleNumber02(int[] nums) {
        int ones = 0;
        int twos = 0;
        for (int i = 0; i < nums.length; i++) {
            ones = (ones ^ nums[i]) & (~twos);
            twos = (twos ^ nums[i]) & (~ones);
        }
        return ones;
    }

    /**
     * map方法实现
     *
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                if (map.get(num) == 1) {
                    map.put(num, 2);
                } else {
                    map.remove(num);
                }
            } else {
                map.put(nums[i], 1);
            }

        }
        int result = map.entrySet().iterator().next().getKey();
        return result;
    }
}
