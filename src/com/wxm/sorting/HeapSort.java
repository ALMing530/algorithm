package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class HeapSort {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 5, 7, 8, 2, 1, 6, 9, 0, 4, 3);// sample data
        System.out.print("Before ordering:");
        arr.forEach(System.out::print);

        sort(arr);

        System.out.println();
        System.out.print("After ordering:");
        arr.forEach(System.out::print);
    }

    public static void sort(List<Integer> arr) {
        int len = arr.size();
        buildHeap(arr);
        for (int i = len - 1; i >= 0; i--) {
            int temp = arr.get(i);
            arr.set(i, arr.get(0));
            arr.set(0,temp);
            heapify(arr,0,i);
        }
    }

    public static void buildHeap(List<Integer> arr) {
        int len = arr.size();
        int index = len/2-1;
        for (int i = index; i >= 0; i--) {
            heapify(arr, i, len);
        }
    }

    public static void heapify(List<Integer> arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr.get(left) > arr.get(largest)) {
            largest = left;
        }
        if (right < len && arr.get(right) > arr.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr,largest,len);
        }
    }

    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, temp);
    }
}
