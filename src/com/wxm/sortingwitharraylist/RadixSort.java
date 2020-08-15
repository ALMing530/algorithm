package com.wxm.sortingwitharraylist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RadixSort {
    public static void main(String[] args) {
        System.out.println("Radix Sort(基数排序)");
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
        List<Integer>[] radix = new List[10];
        for (int i = 0; i < 10; i++) {
            radix[i] = new ArrayList<>();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer integer : arr) {
                int remain = remain(integer, i);
                radix[remain].add(integer);
            }
            arr.clear();
            for(List<Integer> temp:radix){
                arr.addAll(temp);
                temp.clear();
            }
        }
    }
    public static int remain(int i,int round){
        return i/((int)Math.pow(10,round))%10;
    }
}
