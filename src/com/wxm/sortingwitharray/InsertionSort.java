package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 9, 0, 1, 2, 8, 4,5};
        sort(arr);
        for (int a : arr) {
            System.out.print(a);
        }
    }
    public static void sort(int[] arr){
        int len = arr.length;
        for(int i=1;i<len;i++){
            int temp = arr[i];
            for(int j = i-1;j>=0;j--){
                if(arr[j]>temp){
                    Commons.swap(arr,j,j+1);
                }
            }
        }
    }
}
