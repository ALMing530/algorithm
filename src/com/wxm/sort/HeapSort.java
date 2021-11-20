package com.wxm.sort;

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
        //堆化到最后一个节点的时候如果发生了节点交换会递归去堆化叶子节点.
        //此时left和right会超出数组长度，并且叶子节点不需要堆化，所以
        //条件中含left<len和right<len
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
    //建堆
    public static void buildHeap(int[] arr) {
        int len = arr.length;
        //找到第一个需要堆化得节点
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