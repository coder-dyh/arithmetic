package com.dyh.fuxi;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/12 23:11
 * @version: v1.0.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 4, 76, 235, 22};
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int middle = l + ((r - l) >> 1);
        mergeSort(arr, l, middle);
        mergeSort(arr, middle + 1, r);
        merge(arr, l, r, middle);
    }

    public void merge(int arr[], int l, int r, int middle) {
        int[] help = new int[r - l + 1];
        int p1 = l, p2 = middle + 1, i = 0;
        while (p1 <= middle && p2 <= r) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

}
