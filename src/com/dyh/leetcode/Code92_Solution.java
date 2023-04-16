package com.dyh.leetcode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Code92_Solution {

    public static void main(String[] args) {
        Code92_Solution code92Solution = new Code92_Solution();
        code92Solution.test();
    }

    public void test() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        System.out.println(reverseBetween2(head1, 2, 4).toString());

    }


    public ListNode reverseBetween1(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        // 找到left位置的前一个元素
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // pre 固定位置不变
        ListNode cur = pre.next;
        // next 表示cur的下一个，cur表示反转链表中的其中一个元素
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            // 第一步
            cur.next = next.next;
            // 第二步
            next.next = pre.next;
            // 第三步
            pre.next = next;
        }
        return dummyNode.next;

    }

    /**
     * 作者：LeetCode-Jianzhi35_Solution
     * 链接：https://leetcode.cn/problems/reverse-linked-list-ii/solution/fan-zhuan-lian-biao-ii-by-leetcode-solut-teyq/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween3(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        // 找到left位置前一个节点
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode next = null, cur = pre.next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            // 第一步
            cur.next = next.next;
            // 第二步
            next.next = pre.next;
            // 第三步
            pre.next = next;
        }
        return dummyNode.next;
    }


    public ListNode reverseBetween2(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        // 找到left节点的前一个节点
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        // 找到right节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }
        // 断开原链表，得到需要反转的链表
        ListNode node1 = pre.next;
        ListNode node2 = rightNode.next;
        pre.next = null;
        rightNode.next = null;
        // 反转链表
        reverseNodeList(node1);
        // 重新拼接几个部分
        pre.next = rightNode;
        node1.next = node2;

        return dummyNode.next;
    }

    public ListNode reverseNodeList(ListNode head) {
        ListNode pre = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
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
}



