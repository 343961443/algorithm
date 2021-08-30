package com.zs.algorithm.common.ListNode;

/**
 * 反转链表
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
        // 1.令firstNode=N secondNode=1
        // 2.然后如果firstNode已经到达了最后一个位置，secondNode自然就到达了倒数第N个的位置
        for (int i = 0; i < n; i++) {
            firstNode = firstNode.next;
        }
        // 3.但是我们要删除的是第N个元素，所以我们要找到的是倒数第N+1个元素，然后把他的next指向next.next。
        // 所以让firstNode先行一步。当然这一步可以放在上面的for循环里，放这里纯粹是为了理解。
        firstNode = firstNode.next;
        // 然后就ok了
        while (firstNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        secondNode.next = secondNode.next.next;
        return rootNode.next;
    }

    public static void printListNode(ListNode node) {
        ListNode currentNode = node;
        while (currentNode != null) {
            System.out.println(currentNode.val);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        // 反转列表
        //ListNode node = reverseList(head1);
        // 指定位置反转
        //printListNode(reverseList(head1, 2, 4));
        // 移除链表的倒数第N个元素
        printListNode(removeNthFromEnd(head1, 3));
    }

}
