package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShellSort {
    public static void main(String[] args) {
        System.out.println("Shell Sort(希尔排序)");
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
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int temp = arr.get(i);
                int index = i;
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr.get(j) > temp) {
                        arr.set(j + gap, arr.get(j));
                        index -= gap;
//                        arr.set(j, temp);
                    } else {
                        break;
                    }
                }
                arr.set(index, temp);
            }
            gap = gap / 2;
        }
    }
}
