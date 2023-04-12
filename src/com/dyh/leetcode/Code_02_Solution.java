package com.dyh.leetcode;


/**
 * @program: arithmetic
 * @description: 给你两个)非空 的链表，表示两个非负的整数。它们每位数字都是按照)逆序)的方式存储的，并且每个节点只能存储)一位)数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0)开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: dyh
 * @date: 2023/04/09 16:06
 * @version: v1.0.0
 */
public class Code_02_Solution {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(9);
        add(node1, new ListNode(9));
        add(node1, new ListNode(9));

        ListNode node2 = new ListNode(9);
        add(node2, new ListNode(9));
        add(node2, new ListNode(9));
        add(node2, new ListNode(9));
        add(node2, new ListNode(9));

        ListNode res = addTwoNumbers(node1, node2);
        System.out.println(res);
    }

    public static void add(ListNode listNode1, ListNode listNode2) {
        while (listNode1.next != null) {
            listNode1 = listNode1.next;
        }
        listNode1.next = listNode2;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int p1 = 0, p2 = 0, carry = 0, newCarry = 0;
        ListNode resListNode = new ListNode();
        while (l1 != null) {
            while (l2 != null && p1 == p2) {
                newCarry = l1.val + l2.val + carry;
                carry = 0;
                if (newCarry >= 10) {
                    carry = newCarry >= 20 ? 2 : 1;
                }
                add(resListNode, new ListNode(newCarry % 10));
                if (l2 == null) {
                    break;
                }
                p2++;
                l2 = l2.next;

            }
            if (l1 == null) {
                break;
            }
            p1++;
            if (p1 != p2) {
                break;
            }
            l1 = l1.next;
        }
        ListNode last = l1 != null ? l1 : l2;
        while (last != null) {
            newCarry = last.val + carry;
            carry = 0;
            if (newCarry >= 10) {
                carry = newCarry >= 20 ? 2 : 1;
            }
            add(resListNode, new ListNode(newCarry % 10));
            last = last.next;
        }

        if (carry > 0) {
            add(resListNode, new ListNode(carry));
        }

        return resListNode.next;
    }


}

class ListNode {
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
