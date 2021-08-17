package com.zs.algorithm.common;

/**
 * 斐波那契数列
 */
public class Fib {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //递归层数太深，超时了！！
        //return fib(n - 2) + fib(n - 1);
        int a = 0, b = 1, sum = 1;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(10));
    }
}
