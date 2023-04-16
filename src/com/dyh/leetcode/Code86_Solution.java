package com.dyh.leetcode;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你不需要 保留 每个分区中各节点的初始相对位置。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,4,3,2,5,2], x = 3
 * 输出：[1,2,2,4,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [2,1], x = 2
 * 输出：[1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code86_Solution {


    public static void main(String[] args) {
        Code86_Solution code86Solution = new Code86_Solution();
        code86Solution.test();
    }

    public void test() {
        ListNode head1 = new ListNode(4);
        head1.next = new ListNode(7);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(1);
        head1.next.next.next.next = new ListNode(2);

        ListNode listNode = partition1(head1, 3);
        System.out.println(listNode);

    }

    /**
     * 作者：LeetCode-Jianzhi35_Solution
     * 链接：https://leetcode.cn/problems/partition-list-lcci/solution/fen-ge-lian-biao-by-leetcode-solution-iohj/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition1(ListNode head, int x) {
        // 定义两个链表并定义对应指针
        ListNode smallHead = new ListNode(0);
        ListNode smallPointer = smallHead;
        ListNode largeHead = new ListNode(0);
        ListNode largePointer = largeHead;

        while (head != null) {
            if (head.val < x) {
                smallPointer.next = head;
                smallPointer = smallPointer.next;
            } else {
                largePointer.next = head;
                largePointer = largePointer.next;
            }
            head = head.next;
        }
        // 此处仅仅断开最大值的原因为如果是小于x的不需断开，本来就是在前面
        largePointer.next = null;
        smallPointer.next = largeHead.next;
        return smallHead.next;
    }


    public ListNode partition2(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // 定义两个链表一个大于等于x的一个小于x的
        ListNode less = null, p1 = null;
        ListNode more = null, p2 = null;

        ListNode p = head;
        while (p != null) {

            if (head.val < x) {
                if (p1 == null) {
                    p1 = head;
                    less = p1;
                } else {
                    ListNode l = p1;
                    p1 = head;
                    l.next = head;
                }
            } else {
                if (p2 == null) {
                    p2 = head;
                    more = p2;
                } else {
                    ListNode l = p2;
                    p2 = head;
                    l.next = head;
                }
            }
            p = p.next;
        }

        if (p1 != null && p2 != null) {
            p1.next = more;
            return less;
        } else if (p1 != null) {
            return less;
        } else {
            return more;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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