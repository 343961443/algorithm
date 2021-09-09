package com.zs.algorithm.common.ListNode;

import java.util.Arrays;
import java.util.List;

/**
 * 链表
 */
public class ReverseList {
    /**
     * 反转链表的一般实现
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        // 建立一个空节点,
        ListNode pre = null;
        // 当前节点指向，开始循环
        ListNode current = head;
        while (current != null) {
            // 1.把要遍历的下一个节点暂存下来
            ListNode tmp = current.next;
            // 2.遍历的当前节点摘下来，指向我们的新的链表
            current.next = pre;
            // 3.新的链表指向挂了当前节点的链表，这就链接上了
            pre = current;
            // 4.当前节点指向第一步中暂存的节点，用于下一步遍历处理。
            current = tmp;
        }
        return pre;
    }

    /**
     * 反转链表的递归实现
     *
     * @param head
     * @return
     */
    /*public static ListNode reverseList(ListNode head) {
        // 建立一个空节点,
        ListNode pre = null;
        // 当前节点指向，开始循环
        ListNode current = head;
        while (current != null) {
            // 1.把要遍历的下一个节点暂存下来
            ListNode tmp = current.next;
            // 2.遍历的当前节点摘下来，指向我们的新的链表
            current.next = pre;
            // 3.新的链表指向挂了当前节点的链表，这就链接上了
            pre = current;
            // 4.当前节点指向第一步中暂存的节点，用于下一步遍历处理。
            current = tmp;
        }
        return pre;
    }*/

    /**
     * 从指定位置反转链表
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseList(ListNode head, int m, int n) {
        ListNode headRoot = new ListNode(0);
        headRoot.next = head;
        //  m的位置的前一个节点，也就是m-1索引位置的节点
        ListNode pre = null;
        // m位置的开始节点
        ListNode start = null;
        // n位置的节点
        ListNode end = null;
        // n位置后续节点
        ListNode after = null;

        // 找到反转列表的开始位置 m。记录在 start里面
        ListNode current = headRoot;
        int i = 0;
        while (current != null) {
            if (i == m - 1) {
                pre = current;
            } else if (i == m) {
                start = current;
            } else if (i == n) {
                end = current;
            }
            current = current.next;
            i++;
        }
        after = end.next;
        // 断掉n位置的链条
        end.next = null;
        // 反转m-n位置的链表
        pre.next = reverseList(start);
        // 连上后面的节点
        start.next = after;

        return headRoot.next;

    }

    /**
     * 19. 删除链表的倒数第 N 个结点
     */

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // 加根节点，为了符合我们的遍历索引习惯。比如n就是n，而不用弄成n-1
        ListNode rootNode = new ListNode(0);
        rootNode.next = head;

        ListNode firstNode = rootNode;
        ListNode secondNode = rootNode;
        // 倒数第N个位置其实就是需要两个间隔为N-1的指针
        // 1.令firstNode=N secondNode=0
        // 2.然后如果firstNode已经到达了最后一个位置，secondNode自然就到达了倒数第N+1个的位置
        for (int i = 0; i < n; i++) {
            firstNode = firstNode.next;
        }
        // 但是我们要删除的是第N个元素，所以我们要找到的是倒数第N+1个元素，然后把他的next指向next.next。
        // 然后就ok了
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;
        return rootNode.next;
    }

    /**
     * 两两交换
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode rootNode = new ListNode(0);
        rootNode.next = head;
        ListNode current = rootNode;
        while (current.next != null && current.next.next != null) {
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;
            /** 交换第一个，第二个节点，并修改头结点指针 begin**/
            // 第一个节点next指向第三个节点
            firstNode.next = secondNode.next;
            // 第二个节点next指向第一个节点
            secondNode.next = firstNode;
            // head节点指向第二个节点
            current.next = secondNode;
            /** 交换第一个，第二个节点，并修改头结点指针 end**/

            // 当前指针走一下
            current = firstNode;

        }
        return rootNode.next;
    }

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode rootNode = new ListNode(0);
        rootNode.next = head;
        ListNode current = rootNode;
        while (current.next != null) {
            length++;
            current = current.next;
        }
        // 长度为1或者等长
        if (length <= 1 || length == k) {
            return head;
        }
        if (k > length) {
            k = k % length;
        }
        // 找到倒数第k+1个的位置,断开链表，并把从k-末尾的链表挂在头部 双指针 firstNode与secondNode距离是k
        ListNode firstNode = rootNode;
        for (int i = 0; i < k; i++) {
            firstNode = firstNode.next;
        }
        ListNode secondNode = rootNode;
        while (firstNode.next != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        // 断开链表，并把从k-末尾的链表挂在头部
        firstNode.next = rootNode.next;
        rootNode.next = secondNode.next;
        secondNode.next = null;
        return rootNode.next;

    }

    /**
     * 21. 合并两个有序链表
     *
     * @param
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rootNode = new ListNode(0);
        ListNode currentNode = rootNode;
        while (l1 != null && l2 != null) {
            //   谁小给谁放前面
            if (l1.val <= l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            } else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        // 最后肯定剩下一个非空的。搞进去就行了
        currentNode.next = l1 != null ? l1 : l2;
        return rootNode.next;
    }

    /**
     * 删除链表中重复元素
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            //  当前节点与下个节点数字相同
            if (current.val == current.next.val) {
                // 当前节点指向下下个节点
                current.next = current.next.next;
            } else {
                // 当前节点与下个节点数字不同，就指向下一个
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 删除链表中所有重复的节点
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        // 1 1 2 3 4
        ListNode rootNode = new ListNode(0);
        rootNode.next = head;
        ListNode current = rootNode;
        while (current.next != null && current.next.next != null) {
            // 一旦发现了有重复的元素,
            if (current.next.val == current.next.next.val) {
                //  记录一下这个值,然后把指针指向不是这个值的元素
                int i = current.next.val;
                // 一旦是就删除。要注意判空
                while (current.next != null && current.next.val == i) {
                    System.out.println("current.next.val=>" + current.val);
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }

        }
        return rootNode.next;
    }

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallNode = new ListNode(0);
        ListNode largeNode = new ListNode(0);
        // 定义遍历指针
        ListNode tmpSmallNode = smallNode;
        ListNode tmpLargeNode = largeNode;
        // [2,1,3,4,1]  输入 2
        while (head != null) {
            if (head.val < x) {
                tmpSmallNode.next = head;
                tmpSmallNode = tmpSmallNode.next;
            } else {
                tmpLargeNode.next = head;
                tmpLargeNode = tmpLargeNode.next;
            }
            head = head.next;
        }
        // 处理最后一位的next指针
        tmpLargeNode.next = null;
        tmpSmallNode.next = largeNode.next;
        return smallNode.next;
    }

    /**
     * @param node
     */

    public static void printListNode(ListNode node) {
        ListNode currentNode = node;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static ListNode buildListNode(int num) {
        ListNode head1 = new ListNode(0);
        ListNode currentNode = head1;
        for (int i = 0; i < num; i++) {
            currentNode.next = new ListNode(i + 1);
            currentNode = currentNode.next;
        }
        return head1.next;
    }

    public static ListNode buildListNodeFromArray(List<Integer> nums) {
        ListNode head1 = new ListNode(0);
        ListNode currentNode = head1;
        for (Integer num : nums) {
            currentNode.next = new ListNode(num);
            currentNode = currentNode.next;
        }
        return head1.next;
    }

    public static void main(String[] args) {
        ListNode head1 = buildListNode(4);
        // 反转列表
        //ListNode node = reverseList(head1);
        // 指定位置反转
        //printListNode(reverseList(head1, 2, 4));
        // 移除链表的倒数第N个元素
        //printListNode(removeNthFromEnd(head1, 3));

        //printListNode(mergeTwoLists(buildListNode(4), buildListNode(3)));

        //printListNode(swapPairs(buildListNode(4)));

        //printListNode(rotateRight(buildListNode(5), 7));

        //printListNode(deleteDuplicates(buildListNodeFromArray(Arrays.asList(1, 1, 1, 2, 2, 3, 4))));

        printListNode(deleteDuplicates2(buildListNodeFromArray(Arrays.asList(1, 1, 1, 2, 2, 3, 4))));
    }


}
