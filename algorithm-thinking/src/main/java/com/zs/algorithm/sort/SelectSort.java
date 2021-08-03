package com.zs.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 选择排序
 * 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
 *
 * 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
 *
 * 重复第二步，直到所有元素均排序完毕。
 * 算法复杂度： O(n²)
 */
public class SelectSort implements SortInterface {
    @Override
    public int[] sort(int[] array) {
        int [] newArray = Arrays.copyOf(array,  array.length);

        for (int i = 0; i < newArray.length; i++) {
            int tmpMinIndex =  i;
            for (int j = i+1; j < newArray.length; j++) {
                if (newArray[j] < newArray[tmpMinIndex]) {
                    tmpMinIndex  = j;
                }
            }
            int tmpMinValue = newArray[i];
            newArray[i] = newArray[tmpMinIndex];
            newArray[tmpMinIndex] = tmpMinValue;

        }
        return newArray;
    }

    public static void main(String[] args) {
        SelectSort sort =   new SelectSort();
        System.out.println(JSON.toJSONString(sort.sort(sort.getDefaultArray())));
    }
}
