package com.wxm.search;

import com.wxm.sort.HeapSort;

import java.util.Arrays;
/**
 *
 * 功能描述:斐波那契查找
 * @Description
 * @ClassName FibonacciSearch
 * @auther: ALMing
 * @date: 2020/4/5 14:03

 *
 */
public class FibonacciSearch {
    public static void main(String[] args) {
        int[] array = {13, 3, 5, 7, 4, 8, 43, 78, 9, 377, 23, 47, 67, 2, 11};
        HeapSort.sort(array);
        int dist = search(array, 78);
        System.out.format("\n\33[1;34m查找结果：%d\n", dist);
    }

    public static int search(int[] arr, int element) {
        int len = arr.length;
        int[] fib = new int[40];
        for (int i = 0; i < fib.length; i++) {
            if (i <= 1) {
                fib[i] = 1;
            } else {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        int index = 0;
        while (len > fib[index] - 1) {
            index++;
        }

        int low = 0, high = len - 1;
        int[] array = Arrays.copyOf(arr, fib[index]);
        for (int i = high; i < fib[index]; i++) {
            array[i] = array[high]+1;
        }
        while (low <= high) {
            int middle = low + fib[index - 1] - 1;
            if (element < array[middle]) {
                high = middle - 1;
                index = index - 1;
            } else if (element > array[middle]) {
                low = middle + 1;
                index = index - 2;
            } else {
                return array[middle];
            }
        }
        return -1;

    }
}
