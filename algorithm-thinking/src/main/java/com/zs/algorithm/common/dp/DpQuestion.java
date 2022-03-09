package com.zs.algorithm.common.dp;

import java.util.Arrays;

public class DpQuestion {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *  
     *
     * 提示：
     *
     * 1 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/house-robber
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
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

    /**
     * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
     *
     * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     *
     * 你可以认为每种硬币的数量是无限的。
     *
     *
     *
     * 示例 1：
     *
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * 示例 2：
     *
     * 输入：coins = [2], amount = 3
     * 输出：-1
     * 示例 3：
     *
     * 输入：coins = [1], amount = 0
     * 输出：0
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // 定义dp函数 dp[i] i的意义是amount金额， dp[i]表示指定的i金额对应的最小零钱数。
        // dp[i] =  Math.min(
        //      dp[i],
        //      Math.min(dp[i-coins[0]]) + 1,dp[i-coins[1]]) + 1,dp[i-coins[2]]) + 1, ... dp[i-coins[coins数组的长度-1]]) + 1)
        //  )
        int [] dp = new int[amount + 1];
        Arrays.fill(dp, amount +1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 这里不判断。那么  dp[i - coins[j]] 这个索引就越界了。
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1? -1: dp[amount];
    }

    public static void main(String[] args) {
        DpQuestion dpQuestion = new DpQuestion();
        System.out.println(dpQuestion.coinChange(new int[]{1,2,5}, 11));
    }


}
