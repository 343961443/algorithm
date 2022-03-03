package com.zs.algorithm.common.dp;

public class DpQuestion {


    public int rob(int[] nums) {
        // f(k) = max(f(k-1), f(k-2) + N(k))
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = nums[0];
        if (nums.length == 1) {
            return first;
        }
        int second = Math.max(nums[0], nums[1]);
        if (nums.length == 2) {
            return second;
        }
        int tmp;
        for (int i = 2; i < nums.length; i++) {
            tmp = Math.max(second, first + nums[i]);
            first = second;
            second = tmp;

        }
        return second;
    }
}
