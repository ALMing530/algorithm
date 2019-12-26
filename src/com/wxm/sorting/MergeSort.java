package com.wxm.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("Merge Sort(归并排序)");
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<20;i++){
            arr.add(random.nextInt(100));
        }
        System.out.print("Before ordering:\t");
        arr.forEach(integer -> System.out.print(integer + " "));
        List<Integer> toArr = new ArrayList<>();
        sort(arr,0,arr.size()-1);

        System.out.println();
        System.out.print("After ordering:\t\t");
        arr.forEach(integer -> System.out.print(integer + " "));
    }

    public static void sort(List<Integer> arr, int start, int end) {
        if (start == end) {
            return;
        }
        int middle = (start + end) / 2;
        sort(arr, start, middle);
        sort(arr, middle + 1, end);
        merge(arr,start,middle,end);
    }

    public static void merge(List<Integer> arr, int start, int middle, int end) {
        List<Integer> temp= new ArrayList<>(end-start+1);
        int index1 = start;
        int index2 = middle+1;
        while (index1 <= middle && index2 <= end) {
            if(arr.get(index1)<arr.get(index2)){
                temp.add(arr.get(index1++));
            }else {
                temp.add(arr.get(index2++));
            }
        }
        while (index1<=middle){
            temp.add(arr.get(index1++));
        }
        while (index2<=end){
            temp.add(arr.get(index2++));
        }
        for(Integer number:temp){
            arr.set(start++,number);
        }
    }
}
