package com.zs.algorithm.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MovingCount {
    public static void main(String[] args) {
        //机器人的运动范围
        System.out.println(new MovingCount().movingCount(2, 3, 1));
        System.out.println(new MovingCount().movingCount(3, 1, 0));
    }

    public int movingCount(int m, int n, int k) {
        boolean[][] flagArray = new boolean[m][n];
        int[] currentStep = new int[]{0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(currentStep);
        int result = 1;
        while (!queue.isEmpty()) {
            int[] step = queue.poll();
            int x = step[0], y = step[1];
            int[][] moveArray = new int[][]{{0, 1}, {1, 0}};
            for (int i = 0; i < moveArray.length; i++) {
                int xMove = x + moveArray[i][0];
                int yMove = y + moveArray[i][1];
                if (xMove >= m || yMove >= n || flagArray[xMove][yMove] || getSum(xMove) + getSum(yMove) > k) {
                    continue;
                }
                flagArray[xMove][yMove] = true;
                queue.offer(new int[]{xMove, yMove});
                result++;
            }
        }
        return result;
    }

    public int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

}
