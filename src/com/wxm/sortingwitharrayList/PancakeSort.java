package com.wxm.sortingwitharrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PancakeSort {

    public static void main(String[] args) {
        System.out.println("Pancake Sort(饼排序)");
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
        int reLen = len;
        for (int i = 0; i < len-1; i++) {
            int min = Integer.MAX_VALUE;
            int maxIndex = 0;
            for (int j = len - reLen; j < len; j++) {
                if (arr.get(j) < min) {
                    min = arr.get(j);
                    maxIndex = j;
                }
            }
            for (int k = 0; k < (len - maxIndex) / 2; k++) {
                swap(arr,maxIndex,len-1-k);
            }
            for (int n = 0; n < reLen / 2; n++) {
                swap(arr,len-reLen+n,len-1-n);
            }
            reLen--;
        }
    }
    private static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(j);
        arr.set(j, arr.get(i));
        arr.set(i, temp);
    }
}
