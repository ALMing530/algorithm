package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class BubbleSort {
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
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    swap(arr,j,j+1);
                }
            }
        }
    }
    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, temp);
    }
}
