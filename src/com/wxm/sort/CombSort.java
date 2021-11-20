package com.wxm.sort;

import com.wxm.commons.Commons;

public class CombSort {
    public static void main(String[] args) {
        int[] mock = Commons.mockArray();
        sort(mock);
        Commons.printf(mock);
    }
    public static void sort(int[] arr){
        int len = arr.length;
        double factor = 1.3D;
        int delta = (int)(len/factor);
        while (delta>0){
            for(int i=0;i+delta<len;i++){
                if(arr[i]>arr[i+delta]){
                    Commons.swap(arr,i,i+delta);
                }
            }
            delta = (int)(delta/1.3);
        }
    }
}
