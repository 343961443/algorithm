package com.zs.algorithm.common;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        /**
         * 从二维数组右上角开始找
         */
        int i = 0;
        int j = columnNum - 1;
        while (i < rowNum && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
                // 小了忘下找
            } else if (target > matrix[i][j]) {
                i++;
            }
            //  大了忘左找
            else {
                j--;
            }
        }
        return false;
    }
}
