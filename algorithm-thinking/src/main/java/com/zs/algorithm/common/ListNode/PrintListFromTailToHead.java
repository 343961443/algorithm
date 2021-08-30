package com.zs.algorithm.common.ListNode;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Stack;

public class PrintListFromTailToHead {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode nextNode = new ListNode(2);
        listNode.next = nextNode;
        System.out.println(JSON.toJSONString(reversePrint(listNode)));
    }

    ArrayList<Integer> arrayList = new ArrayList<Integer>();

    /*public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode != null) {
            //  打印下一个
            printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

*/
    public static int[] reversePrint(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        int[] array = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            array[i] = stack.pop().intValue();
            i++;
        }
        return array;
    }

}
