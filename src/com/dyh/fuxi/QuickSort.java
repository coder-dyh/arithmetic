package com.dyh.fuxi;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/12 22:42
 * @version: v1.0.0
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 4, 76, 235, 22};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }


    public void sort(int arr[]) {
        if (arr == null || arr.length < 2) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, r, l + (int) (Math.random() * (r - l + 1)));
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }

    }


    private int[] partition(int[] arr, int l, int r) {
        int less = l - 1, more = r;
        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
