package com.zs.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.Random;

public interface SortInterface {
    default int[] getDefaultArray() {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    int[] sort(int[] array);


    default void print() {
        System.out.println(JSON.toJSONString(sort(getDefaultArray())));
    }
}
