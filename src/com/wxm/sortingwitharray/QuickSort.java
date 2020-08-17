package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

public class QuickSort {
    public static void main(String[] args) {
        int[] mock = Commons.mockArray();
        Commons.printf(mock);
        System.out.println();
        sort(mock, 0, mock.length - 1);
        Commons.printf(mock);
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int left = low;
            int right = high;
            int basic = arr[low];
            while (low < high) {
                while (arr[high] >= basic && low < high) high--;
                arr[low] = arr[high];
                while (arr[low] <= basic && low < high) low++;
                arr[high] = arr[low];
            }
            arr[low] = basic;
            sort(arr, left, low - 1);
            sort(arr, low + 1, right);
        }
    }
}
