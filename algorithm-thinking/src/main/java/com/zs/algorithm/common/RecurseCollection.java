package com.zs.algorithm.common;

import java.util.*;

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
     * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
     * <p>
     * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
     * <p>
     * 此外，你可以假设该网格的四条边均被水包围。
     * <p>
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-islands
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入：grid = [
     * ["1","1","1","1","0"],
     * ["1","1","0","1","0"],
     * ["1","1","0","0","0"],
     * ["0","0","0","0","0"]
     * ]
     * 输出：1
     * 输入：grid = [
     * ["1","1","0","0","0"],
     * ["1","1","0","0","0"],
     * ["0","0","1","0","0"],
     * ["0","0","0","1","1"]
     * ]
     * 输出：3
     * <p>
     * [["1","1","1"],
     * ["0","1","0"],
     * ["1","1","1"]]
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int numIsLands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    numIsLands++;
                    // 把后面挨着的岛屿都变成水
                    dsfMarkLandToWater(grid, i, j);
                }
            }
        }
        return numIsLands;
    }

    public void dsfMarkLandToWater(char[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dsfMarkLandToWater(grid, i + 1, j);
        dsfMarkLandToWater(grid, i, j + 1);
        /**
         *   [["1","1","1"],
         *    ["0","1","0"],
         *    ["1","1","1"]]
         *    以此举例表明下面这两行时必须的。因为遍历到第三行第二列时，可能要向左。
         */
        dsfMarkLandToWater(grid, i - 1, j);
        dsfMarkLandToWater(grid, i, j - 1);
    }

    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * Map<Character, String> phoneMap = new HashMap<Character, String>() {{
     * put('2', "abc");
     * put('3', "def");
     * put('4', "ghi");
     * put('5', "jkl");
     * put('6', "mno");
     * put('7', "pqrs");
     * put('8', "tuv");
     * put('9', "wxyz");
     * }};
     *
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        List<String> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        int dept = 0;
        // 1.深度
        // 2.组合
        backTrackLetter(phoneMap, list, sb, dept, digits);
        return list;
    }

    private void backTrackLetter(Map<Character, String> phoneMap, List<String> list, StringBuffer sb, int dept, String digits) {
        if (dept >= digits.length()) {
            list.add(sb.toString());
            return;
        }
        String strCombine = phoneMap.get(digits.charAt(dept));
        for (int i = 0; i < strCombine.length(); i++) {
            sb.append(strCombine.charAt(i));
            backTrackLetter(phoneMap, list, sb, dept + 1, digits);
            sb.deleteCharAt(i);
        }
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * <p>
     * 有效括号组合需满足：左括号必须以正确的顺序闭合。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3
     * 输出：["((()))","(()())","(())()","()(())","()()()"]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：["()"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesis(result, n, 0, 0, new StringBuilder());
        return result;
    }

    public void generateParenthesis(List<String> result, int n, int left, int right, StringBuilder sb) {
        if (left == n && right == n) {
            result.add(sb.toString());
            return;
        }
        if (left < n) {
            sb.append("(");
            generateParenthesis(result, n, left + 1, right, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            generateParenthesis(result, n, left, right + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
     * <p>
     * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例 2：
     * <p>
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     * <p>
     * 输入: candidates = [2], target = 1
     * 输出: []
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        dsfCombinationSum(candidates, 0, candidates.length, target, list, res);
        return res;

    }

    private void dsfCombinationSum(int[] candidates, int begin, int length, int target, LinkedList<Integer> list, List<List<Integer>> res) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList(list));
        }
        for (int i = begin; i < length; i++) {
            list.addLast(candidates[i]);
            // 从i开始再来一遍
            dsfCombinationSum(candidates, i, length, target - candidates[i], list, res);
            list.removeLast();
        }
    }
}
