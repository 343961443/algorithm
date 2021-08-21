package com.zs.algorithm.common;

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
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Dsf {
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

}
