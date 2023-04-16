package com.dyh.leetcode;

import java.util.Arrays;

/**
 * @program: arithmetic
 * @description: 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: dyh
 * @date: 2023/04/11 23:11
 * @version: v1.0.0
 */
public class Code40_Solution {

    public static void main(String[] args) {
        Code40_Solution code40Solution = new Code40_Solution();
        int[] arr = {0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] res = code40Solution.getLeastNumbers(arr, 3);
        for (int re : res) {
            System.out.print(re + " ");
        }
    }

    /**
     * 作者：LeetCode-Jianzhi35_Solution
     * 链接：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/solution/zui-xiao-de-kge-shu-by-leetcode-solution/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] vec = new int[k];
        Arrays.sort(arr);
        for (int i = 0; i < k; ++i) {
            vec[i] = arr[i];
        }
        return vec;
    }


    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
