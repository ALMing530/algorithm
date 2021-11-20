package com.wxm.sort;

import com.wxm.commons.Commons;

public class CountingSort {
    public static void main(String[] args) {
        int[] mock = Commons.mockArray();
        sort(mock);
        Commons.printf(mock);
    }
    public static void sort(int[] arr){
        int max = Commons.max(arr);
        int min = Commons.min(arr);
        int countLen = max-min+1;
        int[] count = new int[countLen];
        for(int temp:arr){
            count[temp-min]++;
        }
        int index=  0;
        for(int i=0;i<countLen;i++){
            for(int j=0;j<count[i];j++){
                arr[index++] = i+min;
            }
        }
    }
}
