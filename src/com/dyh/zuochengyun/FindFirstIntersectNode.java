package com.dyh.zuochengyun;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/19 00:07
 * @version: v1.0.0
 */
public class FindFirstIntersectNode {


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).val);

    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if (head2 == null || head1 == null) {
            return null;
        }
        // 判断两个链表是否是环链
        Node node1 = getLoopNode(head1);
        Node node2 = getLoopNode(head2);
        // 如果两个链表都不是环链
        if (node2 == null && node1 == null) {
            // 两非环链不相交
            return noLoopIntersectNode(head1, head2);
        } else if (node2 != null && node1 != null) {
            // 两个环链相交
            return bothLoop(head1, head2, node1, node2);
        }
        return null;
    }

    public static Node bothLoop(Node head1, Node head2, Node loop1, Node loop2) {
        // 如果两个环链的入环节点相同，说明他们在没入环之前就已经相交
        int n = 0;
        Node cur1 = head1, cur2 = head2;
        if (loop2 == loop1) {
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (n != 0) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? cur1 : cur2;
            cur2 = cur1 == cur2 ? cur1 : cur2;
            while (cur1 != cur2) {
                cur2 = cur2.next;
                cur1 = cur1.next;
            }
            return cur2;
        } else {
            // 如果入环节点不同，则说明两个节点是在环内相交的
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;

        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static Node noLoopIntersectNode(Node head1, Node head2) {
        if (head2 == null || head1 == null) {
            return null;
        }
        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2) {
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }
        return p1;
    }

    public static class Node {
        private int val;
        private Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(int val) {
            this.val = val;
        }
    }

}
