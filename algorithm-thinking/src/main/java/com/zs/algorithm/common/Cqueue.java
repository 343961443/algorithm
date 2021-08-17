package com.zs.algorithm.common;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Cqueue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        while (stack2.size() > 0) {
            stack1.push(stack2.pop());
        }
        if (stack1.size() > 0) {
            return stack1.pop();
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Cqueue cqueue = new Cqueue();
        cqueue.appendTail(1);
        cqueue.deleteHead();
    }
}
