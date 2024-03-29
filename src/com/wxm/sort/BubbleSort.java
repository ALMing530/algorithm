package com.wxm.sort;

import com.wxm.commons.Commons;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 9, 0, 1, 2, 8, 4,5};
        sort(arr);
        for (int a : arr) {
            System.out.print(a);
        }
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            //每循环一次最大元素沉底
            for (int j = 0; j < len - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    Commons.swap(arr, j, j + 1);
                }
            }
        }
    }


}
