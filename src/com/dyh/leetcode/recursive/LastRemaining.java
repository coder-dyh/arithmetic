package com.dyh.leetcode.recursive;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class LastRemaining {

    public static void main(String[] args) {
        System.out.println(lastRemaining(10, 17));
        System.out.println(lastRemaining2(5, 3));

    }

    public static int lastRemaining(int n, int m) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            arrayDeque.offer(i);
        }
        while (arrayDeque.size() > 1) {
            for (int i = 1; i < m; i++) {
                arrayDeque.offer(arrayDeque.poll());
            }
            arrayDeque.poll();
        }
        System.out.println();
        return arrayDeque.peek();
    }


    public static int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
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

    /**
     * 作者：sweetieeyi
     * 链接：<a href="https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining2(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 最后只剩下一个元素，假设这个最后存活的元素为 num, 这个元素最终的的下标一定是0 （因为最后只剩这一个元素），
     * 所以如果我们可以推出上一轮次中这个num的下标，然后根据上一轮num的下标推断出上上一轮num的下标，
     * 直到推断出元素个数为n的那一轮num的下标，那我们就可以根据这个下标获取到最终的元素了。推断过程如下：
     * <p>
     * 首先最后一轮中num的下标一定是0， 这个是已知的。
     * 那上一轮应该是有两个元素，此轮次中 num 的下标为 (0 + m)%n = (0+3)%2 = 1; 说明这一轮删除之前num的下标为1；
     * 再上一轮应该有3个元素，此轮次中 num 的下标为 (1+3)%3 = 1；说明这一轮某元素被删除之前num的下标为1；
     * 再上一轮应该有4个元素，此轮次中 num 的下标为 (1+3)%4 = 0；说明这一轮某元素被删除之前num的下标为0；
     * 再上一轮应该有5个元素，此轮次中 num 的下标为 (0+3)%5 = 3；说明这一轮某元素被删除之前num的下标为3；
     * ....
     * <p>
     * 因为我们要删除的序列为0-n-1, 所以求得下标其实就是求得了最终的结果。比如当n 为5的时候，num的初始下标为3，
     * 所以num就是3，也就是说从0-n-1的序列中， 经过n-1轮的淘汰，3这个元素最终存活下来了，也是最终的结果。
     * <p>
     * 总结一下推导公式：(此轮过后的num下标 + m) % 上轮元素个数 = 上轮num的下标
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining3(int n, int m) {
        int idx = 0;
        for (int i = 2; i <= n; i++) {
            idx = (idx + m) % i;
        }
        return idx;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-by-lee/">答案地址</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining1(int n, int m) {
        return f(n, m);
    }

    public int f(int n, int m) {
        if (n == 1) {
            return 0;
        }
        int x = f(n - 1, m);
        return (m + x) % n;
    }


}