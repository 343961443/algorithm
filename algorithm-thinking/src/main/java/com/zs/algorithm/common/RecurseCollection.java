package com.zs.algorithm.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 递归
 */
public class RecurseCollection {
    /**
     * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     *  示例 1：
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * <p>
     * 输入：board = [["a","b"],["c","d"]], word = "abcd"
     * 输出：false
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     */
    public boolean exist(char[][] board, String word) {
        char[] array = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (this.dsf(board, array, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dsf(char[][] board, char[] wordArray, int i, int j, int k) {
        //  越界了,或者不相等
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || wordArray[k] != board[i][j]) {
            return false;
        }
        // 能走下去的都是 wordArray[k] == board[i][j],如果长度也够了，ok。true
        if (k == wordArray.length - 1) {
            return true;
        }
        board[i][j] = ' ';
        int nextK = k + 1;
        boolean res = dsf(board, wordArray, i + 1, j, nextK) || dsf(board, wordArray, i - 1, j, nextK)
                || dsf(board, wordArray, i, j + 1, nextK) || dsf(board, wordArray, i, j - 1, nextK);
        // wordArray[k] == board[i][j] 所以置回去 没事
        board[i][j] = wordArray[k];
        return res;
    }

    /**
     * 字符串的全排列问题
     */
    public List<List<Integer>> permute(int[] nums) {
        // 回溯算法+dsf
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return result;
        }
        // 使用一个堆栈记录下可能出现的排列
        Stack stack = new Stack();
        int depth = 0;
        boolean[] used = new boolean[len];
        this.dsfForString(result, len, depth, stack, nums, used);
        return result;
    }

    /**
     * @param result 结果
     * @param len    长度
     * @param depth  递归深度
     * @param stack  临时存储的栈
     * @param nums   数组
     * @param used   已使用数组
     */
    private void dsfForString(List<List<Integer>> result, int len, int depth, Stack stack, int[] nums, boolean[] used) {
        if (len == depth) {
            result.add(new ArrayList<>(stack));
            return;
        }
        // 假设nums = [1,2,3]
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            stack.add(nums[i]);
            // 只有深度+1
            dsfForString(result, len, depth + 1, stack, nums, used);
            // 添加了什么，就还原回去
            stack.pop();
        }
    }

    /**
     * Title: 杨辉三角形又称Pascal三角形，它的第i+1行是(a+b)i的展开式的系数。
     * 它的一个重要性质是：三角形中的每个数字等于它两肩上的数字相加。
     * <p>
     * 例如，下面给出了杨辉三角形的前4行：
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     *
     * @description 递归获取杨辉三角指定行、列(从0开始)的值
     * 注意：与是否创建杨辉三角无关
     * @author rico
     * @x 指定行
     * @y 指定列
     */
    public int getValue(int x, int y) {
        if (y <= x && y >= 0) {
            if (y == 0 || x == y) {   // 递归终止条件
                return 1;
            } else {
                // 递归调用，缩小问题的规模
                return getValue(x - 1, y - 1) + getValue(x - 1, y);
            }
        }
        return -1;
    }

    /**
     * @param s
     * @return
     * @description 递归判断一个字符串是否是回文字符串
     * @author rico
     * @created 2017年5月10日 下午5:45:50
     */
    public static boolean isPalindromeString_recursive(String s) {
        int start = 0;
        int end = s.length() - 1;
        if (start <= end) {
        } else {

        }

        return true;
    }


}
