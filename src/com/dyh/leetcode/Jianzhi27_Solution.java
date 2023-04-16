package com.dyh.leetcode;

import java.util.Stack;

/**
 * 剑指 Offer II 027. 回文链表
 * 给定一个链表的 头节点 head ，请判断其是否为回文链表。
 * <p>
 * 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 * <p>
 * 示例 1：
 * <p>
 * 输入: head = [1,2,3,3,2,1]
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: head = [1,2]
 * 输出: false
 */
public class Jianzhi27_Solution {

    public static void main(String[] args) {
        Jianzhi27_Solution solution = new Jianzhi27_Solution();
        solution.test();

    }

    public boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return false;
    }

    public boolean isPalindrome3(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;// 1,2,3,2,1
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (head != null) {
            if (stack.pop().val != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }


    /**
     * 作者：LeetCode-Jianzhi35_Solution
     * 链接：https://leetcode.cn/problems/aMhZSa/solution/hui-wen-lian-biao-by-leetcode-solution-3q3r/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }


    public boolean isPalindrome4(ListNode head) {
        if (head == null) {
            return true;
        }
        // find middle
        ListNode fast = head;
        ListNode slow = head;
        ListNode cur = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse right node list
        ListNode right = reverseList(slow.next);
        cur = head;
        boolean flag = true;
        while (flag && cur != null && right != null) {
            if (cur.val != right.val) {
                flag = false;
            }
            right = right.next;
            cur = cur.next;
        }

        return flag;
    }


    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public void test() {
        Jianzhi27_Solution solution = new Jianzhi27_Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(solution.isPalindrome4(head));

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }


}


