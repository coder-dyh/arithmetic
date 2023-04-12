package com.dyh.leetcode;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/11 19:43
 * @version: v1.0.0
 */
public class Code912_Solution {

    public static void main(String[] args) {
        Code912_Solution code912Solution = new Code912_Solution();
        int[] arr = {1, 4, 2, 36, 87};
        arr = code912Solution.sortArray(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public int[] sortArray(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int middle = l + (r - l) / 2;

        mergeSort(arr, l, middle);
        mergeSort(arr, middle + 1, r);

        merge(arr, l, r, middle);

    }

    public void merge(int[] arr, int start, int end, int middle) {
        int[] help = new int[end - start + 1];
        int i = 0, p1 = start, p2 = middle + 1;
        while (p1 <= middle && p2 <= end) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= end) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[start + i] = help[i];
        }
    }
}
