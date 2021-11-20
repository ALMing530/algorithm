package com.wxm.sort;

import com.wxm.commons.Commons;

import java.util.ArrayList;

public class RadixSort {
    public static void main(String[] args) {
        int[] mock = Commons.mockArray();
//        sort(mock);
        Commons.printf(mock);
        System.out.println();
        sort2(mock);
        Commons.printf(mock);

    }

    //You'd better implement your self ArrayList because the conversion
    // of ArrayList to int[] is so ugly,see sort2 to get more.
    public static void sort(int[] arr) {
        int max = Commons.max(arr);
        int number = bits(max);
        ArrayList<Integer>[] buckets = Commons.emptyArrayLists(10);
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
        int[] addition = new int[len];
        //index是一个记录每个基数位置有多少个数的容器例如对于 7，6，34，567
        //假如现在在计算个位数那么index为 0 0 0 0 1 0 1 2 0 0
        //                           0 1 2 3 4 5 6 7 8 9
        int[] index = new int[10];
        int max = Commons.max(arr);
        int number = bits(max);
        for (int i = 0; i < number; i++) {
            //计算出该基数位置的基数个数。
            for (int temp : arr) {
                index[radix(temp, i)]++;
            }
            //实际上是构建出了一个映射关系，即某个基数桶在数组中的起始位置，主要
            //是为了减少创建基数桶的内存开销同过在一个数组上操作而非二维数组按照
            //前文的 7，6，34，567 来分析那么 会出现 0 0 0 0 1 1 2 4 4 4
            for (int j = 1; j < 10; j++) {
                index[j] += index[j - 1];
            }
            //这里必须是倒序，因为addition数组填充时就是倒序的。
            for (int k = len-1; k >=0; k--) {
                int radix = radix(arr[k], i);
                addition[index[radix] - 1] = arr[k];
                index[radix]=index[radix]-1;
            }
            for (int n = 0; n < 10; n++) {
                index[n] = 0;
            }
            System.arraycopy(addition, 0, arr, 0, len);
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

    //get radix
    public static int radix(int src, int round) {
        return src / ((int) Math.pow(10, round)) % 10;
    }
}
