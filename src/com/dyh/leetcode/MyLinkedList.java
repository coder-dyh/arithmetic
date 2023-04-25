package com.dyh.leetcode;

/**
 * 707. 设计链表
 * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * <p>
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * <p>
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 */
class MyLinkedList {

    private int size;
    private Node head;
    private Node last;

    public MyLinkedList() {
        head = new Node(0);
    }

    /**
     * ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
     * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
     *
     * @param args
     */
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        myLinkedList.get(4);
        myLinkedList.addAtHead(4);
        myLinkedList.addAtIndex(5, 0);
        myLinkedList.addAtHead(6);

        myLinkedList.print();

    }

    public int get(int index) {
        if (index >= size || index < 0) {
            return -1;
        }
        Node node = head;
        while (index >= 0) {
            node = node.next;
            index--;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        Node node = new Node(val);
        Node tmp = head.next;
        head.next = node;
        node.next = tmp;
        size++;
    }

    public void addAtTail(int val) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            node = node.next;
        }
        node.next = new Node(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size || index < 0) {
            return;
        }
        Node node = head;
        for (; index >= 1; index--) {
            node = node.next;
        }
        Node next = node.next;
        Node temp = new Node(val);
        node.next = temp;
        if (next != null) {
            temp.next = next;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0) {
            return;
        }
        Node node = head;
        while (index >= 1) {
            node = node.next;
            index--;
        }
        node.next = node.next.next;
        size--;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    static class Node {
        private int val;
        private Node next;

        public Node() {
        }


        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return val;
        }

        public Node setVal(int val) {
            this.val = val;
            return this;
        }

        public Node getNext() {
            return next;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
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

