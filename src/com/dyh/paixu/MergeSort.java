package com.dyh.paixu;

import java.util.Arrays;

/**
 * @program: mydemo
 * @description: 归并排序
 * @author: dyh
 * @date: 2023/04/02 17:42
 * @version: v1.0.0
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {4, 1, 4, 3, 6, 11, 8};
        sort(arr);

        for (int i : arr) {
            System.out.print(i + ",");
        }
//        Arrays.sort(arr);
    }


    private static void mergeSort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }

//        int md = (start + end) / 2; 这种写法可能溢出
        int middle = start + ((end - start) >> 1);

        mergeSort(arr, start, middle);
        mergeSort(arr, middle + 1, end);

        merge(arr, start, end, middle);
    }


    public static void merge(int[] arr, int start, int end, int middle) {
        int[] helpArray = new int[end - start + 1];
        int i = 0;
        int p1 = start;
        int p2 = middle + 1;

        while (p1 <= middle && p2 <= end) {
            helpArray[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= middle) {
            helpArray[i++] = arr[p1++];
        }

        while (p2 <= end) {
            helpArray[i++] = arr[p2++];
        }

        for (i = 0; i < helpArray.length; i++) {
            arr[start + i] = helpArray[i];
        }
    }


    public static void sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);

    }
}
