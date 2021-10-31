package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = Commons.mockArray();
        int length = arr.length;
        int[] tmpArr = new int[length];
        Commons.printf(arr);
        sort(arr,tmpArr,0,length-1);
        System.out.println();
        Commons.printf(arr);
    }

    public static void sort(int[] arr, int[] tmpArr, int start, int end) {
        if (start == end) {
            return;
        }
        //分治法将数组分为两部分处理。被分出的两个数组同样会被拆分直至不可拆分
        int middle = (start + end) / 2;
        sort(arr, tmpArr, start, middle);
        sort(arr, tmpArr, middle + 1, end);
        merge(arr,tmpArr,start,end,middle);
    }

    public static void merge(int[] arr, int[] tmpArr, int start, int end, int middle) {
        int leftIndex = start;  //逻辑左数组指针
        int rightIndex = middle+1;  //逻辑右数组指针
        int tmpIndex = 0;   //临时数组指针
        //提取两个数组中的较小的元素 append 到临时数组直至某一数组元素被取没，这里的两个数组是逻辑上的两个数组
        while (leftIndex <= middle && rightIndex <= end) {
            if (arr[leftIndex] < arr[rightIndex]) {
                tmpArr[tmpIndex++] = arr[leftIndex++];
            } else {
                tmpArr[tmpIndex++] = arr[rightIndex++];
            }
        }
        //另一个数组可能包含未取内容。取出并 append 到 tmp。
        while (leftIndex <= middle) {
            tmpArr[tmpIndex++] = arr[leftIndex++];
        }
        while (rightIndex <= end) {
            tmpArr[tmpIndex++] = arr[rightIndex++];
        }
        System.arraycopy(tmpArr,0,arr,start,end-start+1);
    }
}
