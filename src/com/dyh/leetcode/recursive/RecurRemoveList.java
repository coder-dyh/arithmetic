package com.dyh.leetcode.recursive;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/30 23:52
 * @version: v1.0.0
 */
public class RecurRemoveList {

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);

        Node res = new Node(0);
        recurRemove(node, res);

        System.out.println(res);

    }

    public static void recurRemove(Node node, Node res) {
        if (node == null) {
            return;
        }
        if (node.val % 2 == 0) {
            System.out.println(node.val);
        } else {
            res = new Node(node.val);
        }
        node = node.next;
        recurRemove(node, res.next);


    }

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
