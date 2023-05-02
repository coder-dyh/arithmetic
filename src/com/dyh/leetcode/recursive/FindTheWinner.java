package com.dyh.leetcode.recursive;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program: arithmetic
 * @description: 1823. 找出游戏的获胜者
 * 共有 n 名小伙伴一起做游戏。小伙伴们围成一圈，按 顺时针顺序 从 1 到 n 编号。确切地说，从第 i 名小伙伴顺时针移动一位会到达第 (i+1) 名小伙伴的位置，其中 1 <= i < n ，从第 n 名小伙伴顺时针移动一位会回到第 1 名小伙伴的位置。
 * <p>
 * 游戏遵循如下规则：
 * <p>
 * 从第 1 名小伙伴所在位置 开始 。
 * 沿着顺时针方向数 k 名小伙伴，计数时需要 包含 起始时的那位小伙伴。逐个绕圈进行计数，一些小伙伴可能会被数过不止一次。
 * 你数到的最后一名小伙伴需要离开圈子，并视作输掉游戏。
 * 如果圈子中仍然有不止一名小伙伴，从刚刚输掉的小伙伴的 顺时针下一位 小伙伴 开始，回到步骤 2 继续执行。
 * 否则，圈子中最后一名小伙伴赢得游戏。
 * 给你参与游戏的小伙伴总数 n ，和一个整数 k ，返回游戏的获胜者。
 *
 * <a href="https://leetcode.cn/problems/find-the-winner-of-the-circular-game/">原题地址</a>
 * @author: dyh
 * @date: 2023/04/28 21:22
 * @version: v1.0.0
 */
public class FindTheWinner {

    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 2));
        System.out.println(findTheWinner1(5, 2));
    }

    public static int findTheWinner(int n, int k) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.addLast(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.addLast(queue.removeFirst());
            }
            queue.removeFirst();
        }
        return queue.peek();
    }


    /**
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode.cn/problems/find-the-winner-of-the-circular-game/solution/zhao-chu-you-xi-de-huo-sheng-zhe-by-leet-w2jd/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @param k
     * @return
     */

    public static int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 1; i <= n; i++) {
            // offer(E e) 在队列尾部添加一个元素，并返回是否成功
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                // poll(E e) 删除队列中第一个元素，并返回该元素的值,如果元素为null，将返回null
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        return queue.peek();
    }

    public static int findTheWinner2(int n, int m) {
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            idx = (idx + m) % i;
        }
        return idx + 1;
    }
}
