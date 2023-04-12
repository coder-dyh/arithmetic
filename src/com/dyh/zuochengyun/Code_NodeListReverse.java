package com.dyh.zuochengyun;

/**
 * @program: arithmetic
 * @description: 反转单向链表
 * @author: dyh
 * @date: 2023/04/09 21:47
 * @version: v1.0.0
 */
public class Code_NodeListReverse {

    /**
     * 作者：wang_ni_ma
     * 链接：https://leetcode.cn/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public static Node reverseNodeList(Node head) {
        Node pre = null, next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        System.out.println(head1);
        head1 = reverseNodeList(head1);
        System.out.println(head1);
    }

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
