package com.wxm.sort;

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
                //从结尾往前找，只要不大于基数就换到前面来，因为初始时arr[low]就等于基数所以基数被换到了high位置
                while (arr[high] >= basic && low < high) high--;
                arr[low] = arr[high];
                //然后从前往后找只要不小于基数就把这个数换到high出，但通过上断代码知道此时high处是基数所以arr[low]
                //所以arr[low]现在是多余的之后大循环重新循环时arr[low]又被替换为arr[high]所以最后会有一个多余的
                //位置，也就是基数的位置
                while (arr[low] <= basic && low < high) low++;
                arr[high] = arr[low];
            }
            //将基数归位
            arr[low] = basic;
            //分治法将数据分片排序。
            sort(arr, left, low - 1);
            sort(arr, low + 1, right);
        }
    }
}
