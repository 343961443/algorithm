package com.zs.algorithm.sort;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 插入排序
 * 将第一待排序序列第一个元素看做一个有序序列，把第二个元素到最后一个元素当成是未排序序列。
 * 从头到尾依次扫描未排序序列，将扫描到的每个元素插入有序序列的适当位置。（如果待插入的元素与有序序列中的某个元素相等，则将待插入元素插入到相等元素的后面。）
 * 直接插入排序
 * 算法复杂度：0（n到n²之间）
 */
public class InsertSort implements SortInterface {
    @Override
    public int[] sort(int[] array) {
        int [] newArray = Arrays.copyOf(array,  array.length);

        for (int i = 1; i < newArray.length; i++) {
            int tempValue  = newArray[i];
            int j = i;
            while (j > 0 && tempValue < newArray[j-1]) {
                newArray[j]  = newArray[j-1];
                // 可以这么做，不要"最终判断"，便于理解。但是其实没必要，因为反正如果条件不满足，还得接着交换，倒不如直接放到最后判断j != i即可
                //newArray[j] = tempValue;
                j--;
            }
            // 最终判断
            if (j != i) {
                newArray[j] = tempValue;
            }

        }
        return newArray;
    }

    public static void main(String[] args) {
        InsertSort insertSort =   new InsertSort();
        System.out.println(JSON.toJSONString(insertSort.sort(insertSort.getDefaultArray())));
    }
}
