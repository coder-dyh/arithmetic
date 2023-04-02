package com.dyh.paixu;

/**
 * @program: arithmetic
 * @description: 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组 的小和。求一个数组 的小和。
 * 例子:[1,3,4,2,5] 1左边比1小的数，没有; 3左边比3小的数，1; 4左 边比4小的数，1、3; 2左边比2小的数，1; 5左边比5小的数，1、3、4、 2; 所以小和为1+1+3+1+1+3+4+2=16
 * <p>
 * 题解：相当于找当前值比右边的小的有多少个，即相当于被加了多少次
 * @author: dyh
 * @date: 2023/04/02 20:43
 * @version: v1.0.0
 */
public class SmallSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 5, 7};

        System.out.println("数组的小和为：" + smallSum(arr));

    }

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }


    public static int mergeSort(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = left + ((right - left) >> 1);

        return mergeSort(arr, left, middle) +
                mergeSort(arr, middle + 1, right) + merge(arr, left, right, middle);
    }

    public static int merge(int[] arr, int left, int right, int middle) {
        int[] help = new int[right - left + 1];
        int p1 = left;
        int p2 = middle + 1;
        int i = 0;
        int res = 0;

        // 数组不越界时将两个数组合并到新数组中
        while (p1 <= middle && p2 <= right) {
            res += arr[p1] < arr[p2] ? arr[p1] * (right - p2 + 1) : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= right) {
            help[i++] = arr[p2++];
        }

        for (i = 0; i < help.length; i++) {
            arr[left + i] = help[i++];
        }
        return res;
    }

}
