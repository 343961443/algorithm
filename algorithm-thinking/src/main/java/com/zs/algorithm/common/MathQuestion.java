package com.zs.algorithm.common;

/**
 * 数学相关问题
 */
public class MathQuestion {
    public static void main(String[] args) {
        System.out.println(new MathQuestion().myAtoi("2147483648"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * <p>
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * <p>
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 123
     * 输出：321
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int rev = 0;
        // 要考虑负数，这里就只能是！=0
        while (x != 0) {
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            // x%10取x的最后一位
            // rev*10+最后一位，计算反转后的数值
            rev = rev * 10 + x % 10;
            x /= 10;

        }
        return rev;
    }

    public int myAtoi(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int res = 0;
        // 0表示没有符号，-1表示-号，1表示+号
        int flag = 0;
        int i = 0;
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }
        // 处理符号
        if (i < chars.length && chars[i] == '-') {
            flag = -1;
            i++;
        } else if (i < chars.length && chars[i] == '+') {
            flag = 1;
            i++;
        }
        while (i < chars.length && (chars[i] >= '0' && chars[i] <= '9')) {
            int dis = chars[i] - '0';
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && dis > 7)) {
                return flag < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + dis;
            System.out.println(res);
            i++;
        }
        return flag < 0 ? -res : res;

    }
}
