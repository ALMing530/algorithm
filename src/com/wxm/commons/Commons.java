package com.wxm.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Commons {
    //swap arr[a] and arr[b] value
    public static void swap(int[] arr, int a, int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void swap(List<Integer> arr, int a, int b) {
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static int max(int[] arr) {
        int len = arr.length;
        int max = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int max(List<Integer> arr) {
        Optional<Integer> max = arr.stream().max(Integer::compareTo);
        return max.orElse(-1);
    }

    public static int min(int[] arr) {
        int len = arr.length;
        int min = arr[0];
        for (int i = 1; i < len; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    public static int min(List<Integer> arr) {
        Optional<Integer> min = arr.stream().min(Integer::compareTo);
        return min.orElse(-1);
    }

    public static int[] mockArray() {
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < 30; i++) {
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static void printf(int[] arr) {
        for (int temp : arr) {
            System.out.print(temp + "-");
        }
    }
}
