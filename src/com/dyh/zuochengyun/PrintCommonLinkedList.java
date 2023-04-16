package com.dyh.zuochengyun;

/**
 * @program: arithmetic
 * @description: 打印链表的公共部分
 * @author: dyh
 * @date: 2023/04/16 15:27
 * @version: v1.0.0
 */
public class PrintCommonLinkedList {


    public static void printCommonPart(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            System.out.println("没有公共部分！");
        }

        while (head1 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.printf(head1.value + " ");
                head2 = head2.next;
                head1 = head1.next;

            }
        }

    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printLinkedList(node1);
        printLinkedList(node2);

        printCommonPart(node1, node2);
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }
}
