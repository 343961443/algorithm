package com.zs.algorithm.common;

import java.util.*;

public class DoubleCursor {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            // 交替移动最短边。
            int dis = j - i;
            maxArea = Math.max(maxArea, dis * Math.min(height[i], height[j]));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }

    /**
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */

    public boolean canJump(int[] nums) {
        // 贪心算法
        int maxCanJump = 0;
        // 动态维护一个当前位置能达到的最远距离的变量
        // 然后判断当前位置是否能到达
        for (int i = 0; i < nums.length; i++) {
            // 判断当前位置可达性
            if (i <= maxCanJump) {
                maxCanJump = Math.max(maxCanJump, i + nums[i]);
                if (maxCanJump >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * <p>
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * 示例 2：
     * <p>
     * 输入：prices = [7,6,4,3,1]
     * 输出：0
     * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i - 1], minPrice);
            if (prices[i] > minPrice) {
                maxProfit = Math.max(prices[i] - minPrice, maxProfit);
            }
        }
        return maxProfit;
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 拿第二个元素时，如果出现了 [-1,-1,0,2] 这种情况,没事，
            //但是如果出现[-1,-1,-1,0,2]为了避免重复判断，就需要continue
            int first = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                // 与上述相同，第二个数的指针
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int second = nums[j];
                int target = -first;
                int k = nums.length - 1;
                // 因为是排好序的数组，那么如果第三个数的指针从尾部开始像左，出现有大于目标值的数，哪还有救，k--即可，否则只能移动第二个数的指针向左
                while (j < k && nums[k] + second > target) {
                    k--;
                }
                // 相同说明k已经不能再移动了
                if (j == k) {
                    break;
                }
                if (second + nums[k] == target) {
                    List<Integer> list = new ArrayList();
                    list.add(first);
                    list.add(second);
                    list.add(nums[k]);
                    res.add(list);
                }

            }


        }
        return res;
    }

}
