package com.wxm.sortingwitharray;

import com.wxm.commons.Commons;

import java.util.ArrayList;

public class RadixSort {
    public static void main(String[] args) {
        int[] mock = Commons.mockArray();
        sort(mock);
//        sort2(mock);
        Commons.printf(mock);
    }

    //You'd better implement your self ArrayList because the conversion
    // of ArrayList to int[] is so ugly,see sort2 to get more.
    public static void sort(int[] arr) {
        int max = Commons.max(arr);
        int number = bits(max);
        ArrayList<Integer>[] buckets = emptyArrayLists(10);
        ArrayList<Integer> tempArr = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            for (int temp : arr) {
                buckets[radix(temp, i)].add(temp);
            }
            for (ArrayList<Integer> temp : buckets) {
                tempArr.addAll(temp);
                temp.clear();
            }
            for (int j = 0; j < arr.length; j++) {
                arr[j] = tempArr.get(j);
            }
            tempArr.clear();
        }
    }

    public static void sort2(int[] arr) {
        int len = arr.length;
        int[] tempArr = new int[len];
        int[] index = new int[10];
        int max = Commons.max(arr);
        int number = bits(max);
        for (int i = 0; i < number; i++) {
            for (int temp : arr) {
                index[radix(temp, i)]++;
            }
            for (int j = 1; j < 10; j++) {
                index[j] += index[j - 1];
            }
            for (int k = len - 1; k >= 0; k--) {
                int radix = radix(arr[k], i);
                tempArr[index[radix] - 1] = arr[k];
                index[radix]--;
            }
            for (int n = 0; n < 10; n++) {
                index[n] = 0;
            }
            System.arraycopy(tempArr, 0, arr, 0, len);
        }

    }

    //Only for positive integer
    public static int bits(int a) {
        int i = 0;
        for (; a > 0; a = a / 10) {
            i++;
        }
        return i;
    }

    public static ArrayList<Integer>[] emptyArrayLists(int capacity) {
        ArrayList<Integer>[] arr = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            arr[i] = new ArrayList<>();
        }
        return arr;
    }

    //get radix
    public static int radix(int src, int round) {
        return src / ((int) Math.pow(10, round)) % 10;
    }
}
