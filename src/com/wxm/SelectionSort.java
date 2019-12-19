package com.wxm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class SelectionSort {
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

        sort(t);

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
            int min = Integer.MAX_VALUE;
            int maxIndex = 0;
            for (int j = i; j < len; j++) {
                if (arr.get(j) < min) {
                    min = arr.get(j);
                    maxIndex = j;
                }
            }
            arr.set(maxIndex, arr.get(i));
            arr.set(i, min);
        }
    }
}
