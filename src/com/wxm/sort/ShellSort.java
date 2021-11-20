package com.wxm.sort;

import com.wxm.commons.Commons;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 9, 0, 1, 2, 8, 4,5};
        sort(arr);
        for (int a : arr) {
            System.out.print(a);
        }
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        for (int i = gap; i > 0;i = i/2) {
            //按照步进i执行插入排序，步进逐渐缩小最终等于1
            for (int j = i; j < len; j+=i) {
                int temp = arr[j];
                for(int k=j-i;k>=0;k-=i){
                    if(temp<arr[k]){
                        Commons.swap(arr,k,k+i);
                    }
                }
            }
        }
    }
}
