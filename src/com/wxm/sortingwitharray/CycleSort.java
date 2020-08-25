package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

import java.util.ArrayList;
//It will not work in an array which have repeated element
public class CycleSort {
    public static void main(String[] args) {
        int[] mock = {1,6,3,5,8,4,2,10,7,9,25,15};
        sort(mock);
        Commons.printf(mock);
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        ArrayList<Integer> circleArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(circleArr.contains(arr[i])){
                continue;
            }
            int currentElement = arr[i];
            while (true) {
                int index = 0;
                for (int j = 0; j < len; j++) {
                    if(i!=j){
                        if (arr[j] < currentElement) {
                            index++;
                        }
                    }
                }
                int temp = arr[index];
                arr[index] = currentElement;
                currentElement =temp;
                circleArr.add(currentElement);
                if(index==i){
                    break;
                }
            }
        }
    }
}
