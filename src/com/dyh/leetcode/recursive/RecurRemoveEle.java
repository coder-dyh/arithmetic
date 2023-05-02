package com.dyh.leetcode.recursive;

/**
 * @program: arithmetic
 * @description: 390. 消除游戏
 * 列表 arr 由在范围 [1, n] 中的所有整数组成，并按严格递增排序。请你对 arr 应用下述算法：
 * <p>
 * 从左到右，删除第一个数字，然后每隔一个数字删除一个，直到到达列表末尾。
 * 重复上面的步骤，但这次是从右到左。也就是，删除最右侧的数字，然后剩下的数字每隔一个删除一个。
 * 不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
 * 给你整数 n ，返回 arr 最后剩下的数字。
 * <a href="https://leetcode.cn/problems/elimination-game">原文链接</a>
 * @author: dyh
 * @date: 2023/04/26 19:49
 * @version: v1.0.0
 */
public class RecurRemoveEle {

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5 false
        // 1, 2, 3, 4 true
        System.out.println("result:" + lastRemaining(3));
    }

    public static int lastRemaining(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
//            System.out.printf(arr[i] + " ");
        }
//        System.out.println();
        return removeRecur(arr);
    }

    static int removeRecur(int[] arr) {
        if (arr.length <= 1) {
            return arr[0];
        }
        // 从左到右删除
        int step = 1, i = 0, j = 0;
        boolean flag = arr.length % 2 == 0;
        int length = arr.length / 2;
        int[] help1 = new int[length];
        length = arr.length % 2 == 0 ? arr.length / 2 : (arr.length + 1) / 2 - 1;
        for (i = 0; i < length; i++) {
            help1[j++] = arr[i * 2 + 1];
        }
        if (help1.length == 1) {
            return help1[0];
        }
//        print(help1);
        return removeRecur(reverseArr(help1));
    }

    static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] reverseArr(int[] arr) {
        int[] res = new int[arr.length];
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            res[j++] = arr[i];
        }
        return res;
    }

    /**
     * 作者：LeetCode-Solution
     * 链接：<a href="https://leetcode.cn/problems/elimination-game/solution/xiao-chu-you-xi-by-leetcode-solution-ydpb/">...</a>
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public static int lastRemaining1(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 = a1 + step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }

    /**
     * 因为n个数经过一轮消除后剩下n/2个数，设n个数最后消除的结果是其中的第i个数，
     * 设n/2个数最后消除的结果是其中的第j个数，可以推导出代码中的公式，如果觉得
     * 不直观的话可以画个图，公式推导出来后就可以自顶向下递归求解
     *
     * @param n
     * @return
     */
    public static int lastRemaining2(int n) {
        if (n == 1) {
            return 1;
        } else {
            return 2 * (n / 2 + 1 - lastRemaining2(n / 2));
        }
    }

    public static int lastRemaining3(int n) {
        int start = 1, step = 1;
        boolean flag = true;
        while (n > 1) {
            if (flag || (n & 1) == 1) {
                start += step;
            }
            flag = !flag;
            n = n >> 1;
            step = step << 1;
        }
        return start;
    }

}
