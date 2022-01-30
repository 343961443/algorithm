package com.zs.algorithm.common;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        //lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
    }

    int size;
    int capacity;
    Map<Integer, Node> cache = new HashMap<Integer, Node>();
    Node head;
    Node tail;

    class Node {
        Node pre;
        Node next;
        int value;
        int key;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            // moveToHead;
            Node node = cache.get(key);
            //1.deleteNode
            deleteNode(node);
            // 2.addToHead
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void addToHead(Node node) {
        Node headNextNode = head.next;
        // 左边先连上
        head.next = node;
        node.pre = head;
        // 右边再连上
        node.next = headNextNode;
        headNextNode.pre = node;
    }

    public void deleteNode(Node node) {
        // 前后游节点先连上
        node.pre.next = node.next;
        node.next.pre = node.pre;
        // 摘了自己
        node.pre = null;
        node.next = null;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);

        if (cache.containsKey(key)) {
            // moveToHead;
            Node oldNode = cache.get(key);
            //1.deleteNode
            deleteNode(oldNode);
            // 2.addToHead
            addToHead(node);
            cache.put(key, node);
        } else {
            addToHead(node);
            cache.put(key, node);
            size++;
            if (size > capacity) {
                Node pre = tail.pre;
                deleteNode(pre);
                cache.remove(pre.key);
                size--;
            }
        }
    }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
