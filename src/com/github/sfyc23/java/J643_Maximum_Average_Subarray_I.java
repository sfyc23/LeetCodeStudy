package com.github.sfyc23.java;

/**
 * 643. Maximum Average Subarray I
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value. And you need to output the maximum average value.
 * <p>
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class J643_Maximum_Average_Subarray_I {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 6));

    }


    //白痴做法
    public static double findMaxAverage(int[] nums, int k) {

        int maxNum = sum(nums, k - 1, k);
        int sum = maxNum;
        for (int i = k; i < nums.length; i++) {
            sum = sum + nums[i] - nums[i - k];
            maxNum = Math.max(sum, maxNum);
        }


        return maxNum / 1.0 / k;
    }

    public static int sum(int[] nums, int over, int k) {
        int sum = 0;
        while (k-- > 0) {
            sum += nums[over--];
        }
        return sum;
    }
}
