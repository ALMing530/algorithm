package com.wxm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CountingSort {
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
        int max = maxValue(arr);
        int min = minValue(arr);
        int countArrLen = max - min + 1;
        int[] countArr = new int[countArrLen];
        for (Integer temp : arr) {
            countArr[temp - min]++;
        }
        arr.clear();
        for (int j = 0; j < countArrLen; j++) {
            for (int k = 0; k < countArr[j]; k++) {
                arr.add(j + min);
            }
        }

    }

    public static int maxValue(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (Integer temp : arr) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static int minValue(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (Integer temp : arr) {
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}