package com.dyh.leetcode.recursive;

/**
 * @program: arithmetic
 * @description: 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <a href="https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/">原文地址</a>
 * @author: dyh
 * @date: 2023/04/25 22:14
 * @version: v1.0.0
 */
public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
