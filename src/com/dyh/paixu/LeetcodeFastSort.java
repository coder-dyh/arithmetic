package com.dyh.paixu;

import java.util.Random;

/**
 * @program: arithmetic
 * @description: 作者：LeetCode-Solution
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: dyh
 * @date: 2023/04/04 22:25
 * @version: v1.0.0
 */
public class LeetcodeFastSort {

    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(findKthLargest1(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));

    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.println(i);
        }
        System.out.println("===================");
    }


    public static int findKthLargest1(int[] nums, int k) {
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        int k1 = 0;
        for (int i = count.length - 1; i >= 0; i--) {
//            k1+=count[i];
            k1 = count[i] + k1;
            if (k1 >= k) {
                return i + min;
            }
        }
        return 0;
    }

    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public static int quickSelect(int[] a, int l, int r, int index) {
        // 得到划分值
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public static int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public static int partition(int[] a, int l, int r) {
        // 定义i为左边界
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }
        swap(a, i + 1, r);
        return i + 1;
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
