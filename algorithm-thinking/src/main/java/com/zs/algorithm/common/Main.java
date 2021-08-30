package com.zs.algorithm.common;

public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        int m = 2, n = 4;
        Node node = reverse(node1, m, n);
        Node tempNode = null;
        while ((tempNode = node.getNext()) != null) {
            System.out.println(tempNode.getValue());
        }

    }

    public static Node reverse(Node node, int m, int n) {
        Node result = new Node(0);
        int i = 0;
        while (node != null) {

        }
        return result.getNext();
    }


    public static class Node {
        public Node(int value) {
            this.value = value;
        }

        private int value;
        private Node next;

        public Node getNext() {
            return next;
        }

        public void setNext(Node node) {
            this.next = node;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }


    }
}

