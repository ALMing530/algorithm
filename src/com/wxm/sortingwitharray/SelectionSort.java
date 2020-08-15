package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 9, 0, 1, 2, 8, 4,5};
        sort(arr);
        for (int a : arr) {
            System.out.print(a);
        }
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            Commons.swap(arr,i,index);
        }
    }
}
