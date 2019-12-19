package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class BubbleSort {
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
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j + 1);
                    arr.set(j + 1, arr.get(j));
                    arr.set(j, temp);
                }
            }
        }
    }
}
