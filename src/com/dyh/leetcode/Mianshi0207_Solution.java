package com.dyh.leetcode;


public class Mianshi0207_Solution {

    public static void main(String[] args) {

    }

    /**
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode.cn/problems/intersection-of-two-linked-lists-lcci/solution/lian-biao-xiang-jiao-by-leetcode-solutio-2kne/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


}