package com.zs.algorithm.sort;

import com.alibaba.fastjson.JSON;

public class PrintUtil {
    public static void print(SortInterface sortInterface) {
        System.out.println(JSON.toJSONString(sortInterface.sort(sortInterface.getDefaultArray())));
    }
}
