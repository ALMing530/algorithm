package com.wxm.serch;

import com.wxm.sortingwitharray.HeapSort;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {13, 3, 5, 7, 4, 8, 43, 78, 9, 377, 23, 47, 67, 2, 11};
        HeapSort.sort(array);
        int dist = search(array, 0, array.length-1, 47);
        System.out.format("\n\33[1;34m查找结果：%d\n", dist);

    }

    private static int search(int[] array, int low, int high, int element) {
        int dist = -1;
        if (high - low == 1) {
            if (element == array[low]) {
                dist = array[low];
            }
            return dist;
        }
        int middle = (low + high) / 2;
        if (element > array[middle]) {
            dist = search(array, middle + 1, high, element);
        } else if (element < array[middle]) {
            dist = search(array, low, middle - 1, element);
        } else if (element == array[middle]) {
            dist = array[middle];
        }
        return dist;
    }
}

