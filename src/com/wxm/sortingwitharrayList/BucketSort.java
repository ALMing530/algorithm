package com.wxm.sortingwitharrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BucketSort {
    public static void main(String[] args) {
        System.out.println("Bucket Sort(桶排序)");
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<20;i++){
            arr.add(random.nextInt(100));
        }
        System.out.print("Before ordering:\t");
        arr.forEach(integer -> System.out.print(integer+" "));

        sort(arr);

        System.out.println();
        System.out.print("After ordering:\t\t");
        arr.forEach(integer -> System.out.print(integer+" "));
    }
    public static void sort(List<Integer> arr){
        int bucketCount = 5;
        List<Integer>[] buckets = new List[bucketCount];
        for(int i=0;i<bucketCount;i++){
            buckets[i] = new ArrayList<>();
        }
        int max = max(arr);
        int min = min(arr);
        int fragment = (max-min)/(bucketCount-1);
        for(Integer temp:arr){
             int index = temp/fragment;
             buckets[index].add(temp);
        }
//        List<Integer> result = new ArrayList<>();
        arr.clear();
        for(int i=0;i<bucketCount;i++){
            InsertionSort.sort(buckets[i]);
            arr.addAll(buckets[i]);
        }

    }
    public static int max(List<Integer> arr){
        int max = Integer.MIN_VALUE;
        for(Integer temp:arr){
            if(temp>max){
                max = temp;
            }
        }
        return max;
    }
    public static int min(List<Integer> arr){
        int min = Integer.MAX_VALUE;
        for(Integer temp:arr){
            if(temp<min){
                min = temp;
            }
        }
        return min;
    }
}
