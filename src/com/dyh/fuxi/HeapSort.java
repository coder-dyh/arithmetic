package com.dyh.fuxi;

/**
 * @program: arithmetic
 * @description:
 * @author: dyh
 * @date: 2023/04/13 20:27
 * @version: v1.0.0
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {2, 6, 3, 4, 76, 235, 22};
        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
    }


    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int i = 0;
        for (; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;
        swap(arr, --size, 0);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, --size, 0);
        }
    }

    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public void heapify(int[] arr, int index, int size) {
        int left = index * 2 + 1;
        while (left < size) {
            int largest = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }


    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
