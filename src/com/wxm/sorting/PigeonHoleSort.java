package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PigeonHoleSort {
    public static void main(String[] args) {
        System.out.println("Pigeon Hole Sort(鸽巢排序)");
        List<Integer> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            arr.add(random.nextInt(100));
        }
        System.out.print("Before ordering:\t");
        arr.forEach(integer -> System.out.print(integer + " "));

        sort(arr);

        System.out.println();
        System.out.print("After ordering:\t\t");
        arr.forEach(integer -> System.out.print(integer + " "));
    }

    public static void sort(List<Integer> arr) {
        int max = maxValue(arr);
        int min = minValue(arr);
        int holeCount = max-min+1;
        List<Integer>[] holes = new List[holeCount];
        for(int i=0;i<holeCount;i++){
            holes[i] = new ArrayList<>();
        }
        for(Integer temp:arr){
            holes[temp-min].add(temp);
        }
        arr.clear();
        for(List<Integer> temp:holes){
            arr.addAll(temp);
        }
    }

    public static int maxValue(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        for (Integer temp : arr) {
            if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static int minValue(List<Integer> arr) {
        int min = Integer.MAX_VALUE;
        for (Integer temp : arr) {
            if (temp < min) {
                min = temp;
            }
        }
        return min;
    }
}
