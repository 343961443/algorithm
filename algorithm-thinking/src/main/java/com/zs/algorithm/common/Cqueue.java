package com.zs.algorithm.common;

import com.alibaba.fastjson.JSON;

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
        // 如果不事先判断stack1为空时再push，会出现一种情况，stack1先 push 12，然后pop出来2，然后push3，pop出来的却是1
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
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
        cqueue.appendTail(2);
        System.out.println(JSON.toJSONString(cqueue));
        System.out.println(cqueue.deleteHead());
        System.out.println(JSON.toJSONString(cqueue));
        cqueue.appendTail(3);
        System.out.println(JSON.toJSONString(cqueue));
        System.out.println(cqueue.deleteHead());
        System.out.println(JSON.toJSONString(cqueue));
        cqueue.appendTail(4);
        cqueue.appendTail(5);
        System.out.println(cqueue.deleteHead());
        System.out.println(cqueue.deleteHead());
        System.out.println(cqueue.deleteHead());
        System.out.println(cqueue.deleteHead());
    }

    public Stack<Integer> getStack1() {
        return stack1;
    }

    public void setStack1(Stack<Integer> stack1) {
        this.stack1 = stack1;
    }

    public Stack<Integer> getStack2() {
        return stack2;
    }

    public void setStack2(Stack<Integer> stack2) {
        this.stack2 = stack2;
    }
}
