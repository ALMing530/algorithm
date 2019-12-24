package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CombSort {
    public static void main(String[] args) {
        System.out.println("Comb Sort(梳排序)");
        List<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 5, 7, 8, 2, 1, 6, 9, 0, 4, 3);// sample data
        System.out.print("Before ordering:\t");
        arr.forEach(integer -> System.out.print(integer+" "));

        sort(arr);

        System.out.println();
        System.out.print("After ordering:\t\t");
        arr.forEach(integer -> System.out.print(integer+" "));
    }

    public static void sort(List<Integer> arr) {
        int len = arr.size();
        int i = (int) (len / 1.3);
        while (i > 3) {
            for (int j = 0; j < len - i; j++) {
                if (arr.get(j) > arr.get(j + i)) {
                    swap(arr,j,j+i);
                }
            }
            i = (int) (i / 1.3);
        }
        // BubbleSort.sort(arr);
        for (int k = 0; k < len - 1; k++) {
            for (int j = 0; j < len - 1 - k; j++) {
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
