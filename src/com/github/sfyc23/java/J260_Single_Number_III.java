package com.github.sfyc23.java;

import java.util.*;

/**
 * 260. Single Number III
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * For example:
 * <p>
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * <p>
 * Note:
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 */
public class J260_Single_Number_III {


    public static void main(String[] args) {

        int i = 7 ^ 6;
//        System.out.println(i & -i & 6);


        int test = 6;

//        System.out.println(Integer.toBinaryString(test));
//        System.out.println(Integer.toBinaryString(-test));
//        System.out.println(Integer.toBinaryString(test & -test));

        //奇数
//      1 == A & -A

        int a = 6;
        int b= 8;
        test = a ^ b;
        System.out.println(test);
        test &= -test;
        System.out.println(test);
        System.out.println(test & 6);
        System.out.println(test & 8);


        int[] nums = new int[]{3, 8, 6, 3};
        singleNumber03(nums);
    }


    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.remove(nums[0]);
            } else {
                map.put(nums[0], i);
            }
        }
        int[] result = new int[map.size()];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index++] = entry.getKey();
        }

        return result;
    }


    public static int[] singleNumber02(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                hashSet.remove(nums[i]);
            } else {
                hashSet.add(nums[i]);
            }
        }
        int[] result = new int[hashSet.size()];
        int index = 0;
        for (Iterator<Integer> it = hashSet.iterator(); it.hasNext(); ) {
            Integer in = it.next();
            result[index++] = in;
        }

        return result;
    }

    public static int[] singleNumber03(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        System.out.println(Integer.toBinaryString(diff));


        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums) {
            // the bit is not set
            if ((num & diff) == 0) {
                rets[0] ^= num;
            } else {//// the bit is set
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
