package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 9, 0, 1, 2, 8, 4,5};
        sort(arr);
        Commons.printf(arr);
    }
    public static void sort(int[] arr){
        int len = arr.length;
        //从第二个元素也就是索引为1的元素开始遍历
        for(int i=1;i<len;i++){
            //然后从当前元素开始倒叙向前遍历，发现前一个元素比自己大就调换二者位置
            for(int j = i-1;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    Commons.swap(arr,j,j+1);
                }else {
                    //因为当前元素前的数据已经是有序的了所以只要前一个元素不大于比较元素就
                    //可以停止遍历了
                    break;
                }
            }
        }
    }
}
