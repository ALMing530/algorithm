package com.wxm.sortingwitharray;

public class HeapSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        buildHeap(arr);
        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    public static void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest, len);
        }
    }

    public static void buildHeap(int[] arr) {
        int len = arr.length;
        int firstNonLeafNode = len / 2 - 1;
        for (int i = firstNonLeafNode; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
}