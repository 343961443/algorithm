package com.zs.algorithm.common;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        System.out.println(findRepeatNumber.findRepeatNumber(new int[]{1, 2, 3, 3}));
    }
}
