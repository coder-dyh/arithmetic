package com.dyh.leetcode;

/**
 * 1171. 从链表中删去总和值为零的连续节点
 * 给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。
 * <p>
 * 删除完毕后，请你返回最终结果链表的头节点。
 * <p>
 * 你可以返回任何满足题目要求的答案。
 * <p>
 * （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。）
 */
class RemoveZeroSumSublists_Solution {


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(-3);
        head1.next.next.next.next = new ListNode(-2);

        RemoveZeroSumSublists_Solution solution = new RemoveZeroSumSublists_Solution();
        System.out.println(solution.removeZeroSumSublists(head1));
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(10000);
        dummyNode.next = head;
        ListNode cur = head;
        ListNode pre = dummyNode;
        while (cur.next != null) {
            if (cur.next.val + cur.val == 0) {
                pre.next = cur.next.next;
                cur = dummyNode;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyNode.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
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