package com.wxm.sortingwitharrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("Insertion Sort(插入排序)");
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
        for (int i = 1; i < len; i++) {
            int temp = arr.get(i);
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (temp < arr.get(j)) {
                    arr.set(j + 1, arr.get(j));
                    index--;
//                    arr.set(j, temp);
                } else {
                    break;
                }
            }
            arr.set(index,temp);
        }
    }
}
