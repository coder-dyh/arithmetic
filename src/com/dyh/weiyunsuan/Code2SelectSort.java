package com.dyh.weiyunsuan;

/**
 * @program: mydemo
 * @description: 选择排序
 * @author: dyh
 * @date: 2023/03/29 22:53
 * @version: v1.0.0
 */
public class Code2SelectSort {

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 4, 56, 4, 5, 2};
        printArr(arr);
        System.out.println();
        printArr(sort(arr));


        int x = 5, y = 5;
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
        System.out.println();
        System.out.println(x + " " + y);
    }


    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            // 1 ---- n
            // 2 ---- n-1
            // 3 ---- n -2
            // .....
            int minValueIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int eor = arr[i];
        arr[i] = arr[j];
        arr[j] = eor;

    }

    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
