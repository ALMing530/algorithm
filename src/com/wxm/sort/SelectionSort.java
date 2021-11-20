package com.wxm.sort;

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
            //初始时就假定第一个元素是最小元素
            int min = arr[i];
            //然后在剩余元素中查找最小元素并记录索引，最后将找到的最小元素放在它该在的位置
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
