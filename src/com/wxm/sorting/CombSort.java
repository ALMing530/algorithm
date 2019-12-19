package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CombSort {
    public static void main(String[] args) {
        List<Integer> t = new ArrayList<>();
        Collections.addAll(t, 5, 7, 8, 2, 1, 6, 9, 0, 4, 3);// sample data
        System.out.print("Before ordering:");
        t.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer);
            }
        });

        sort(t);//sort

        System.out.println();
        System.out.print("After ordering:");
        t.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer);
            }
        });
    }

    public static void sort(List<Integer> arr) {
        int len = arr.size();
        int i = (int) (len / 1.3);
        while (i > 3) {
            for (int j = 0; j < len - i; j++) {
                if (arr.get(j) > arr.get(j + i)) {
                    int temp = arr.get(j + i);
                    arr.set(j + i, arr.get(j));
                    arr.set(j, temp);
                }
            }
            i = (int) (i / 1.3);
        }
        System.out.println();
        arr.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.print(integer);
            }
        });
        // BubbleSort.sort(arr);
        for (int k = 0; k < len - 1; k++) {
            for (int j = 0; j < len - 1 - k; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j + 1);
                    arr.set(j + 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
}
