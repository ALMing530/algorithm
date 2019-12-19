package com.wxm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class PancakeSort {

    public static void main(String[] args) {
        List<Integer> t = new ArrayList<>();
        Collections.addAll(t, 5, 7, 8, 2, 1, 6, 9, 0,4, 3);// sample data
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
        int reLen = len;
        for (int i = 0; i < len - 2; i++) {
            int min = Integer.MAX_VALUE;
            int maxIndex = 0;
            for (int j = len - reLen; j < len; j++) {
                if (arr.get(j) < min) {
                    min = arr.get(j);
                    maxIndex = j;
                }
            }
            for (int k = 0; k < (len - maxIndex) / 2; k++) {
                int temp = arr.get(len - 1 - k);
                arr.set(len - 1 - k, arr.get(maxIndex + k));
                arr.set(maxIndex + k, temp);
            }
            for (int n = 0; n < reLen / 2; n++) {
                int temp = arr.get(len - 1 - n);
                arr.set(len - 1 - n, arr.get(len - reLen + n));
                arr.set(len - reLen + n, temp);
            }
            reLen--;
        }
    }
}
