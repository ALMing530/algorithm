package com.wxm.sortingwitharraylist;

import com.wxm.commons.Commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Quick Sort()");
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            arr.add(random.nextInt(100));
        }
        System.out.print("Before ordering:\t");
        arr.forEach(integer -> System.out.print(integer + " "));
        sort(arr, 0, arr.size() - 1);

        System.out.println();
        System.out.print("After ordering:\t\t");
        arr.forEach(integer -> System.out.print(integer + " "));
    }

    public static void sort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int left = low;
            int right = high;
            int current = arr.get(low);
            while (low < high) {
                while (arr.get(high) > current) {
                    high--;
                }
                while (arr.get(low) <= current && low < high) {
                    low++;
                }
                if (low < high) {
                    Commons.swap(arr, low, high);
                }
            }
            Commons.swap(arr, left, low);
            sort(arr, left, low - 1);
            sort(arr, low + 1, right);
        }
    }
}
