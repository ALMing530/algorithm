package com.wxm.sortingwitharrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Quick Sort()");
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            arr.add(random.nextInt(100));
        }
        System.out.print("Before ordering:\t");
        arr.forEach(integer -> System.out.print(integer + " "));
        sort(arr, 0, arr.size() - 1);

        System.out.println();
        System.out.print("After ordering:\t\t");
        arr.forEach(integer -> System.out.print(integer + " "));
    }

    public static void sort(List<Integer> arr, int low, int high) {
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int current = arr.get(i);
        while (j>i){
            while (arr.get(j)>current){
                j--;
            }
            while(arr.get(i)<=current&&i<j){
                i++;
            }
            if(i<j){
                int temp = arr.get(j);
                arr.set(j, arr.get(i));
                arr.set(i, temp);
            }
        }
        int temp = arr.get(i);
        arr.set(i,arr.get(low));
        arr.set(low,temp);
        sort(arr,low,i-1);
        sort(arr,i+1,high);
    }
}
