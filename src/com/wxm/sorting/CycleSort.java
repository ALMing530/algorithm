package com.wxm.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class CycleSort {
    public static void main(String[] args) {
        System.out.println("Cycle Sort(圈排序)");
        List<Integer> arr = new ArrayList<>();
        Collections.addAll(arr, 5, 7, 8, 2, 1, 6, 9, 0, 4, 3);// sample data
        System.out.print("Before ordering:\t");
        arr.forEach(integer -> System.out.print(integer+" "));

        sort(arr);

        System.out.println();
        System.out.print("After ordering:\t\t");
        arr.forEach(integer -> System.out.print(integer+" "));
    }

    public static void sort(List<Integer> arr) {
        int len = arr.size();
        List<Integer> circleArr = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(circleArr.contains(arr.get(i))){
                break;
            }
            int currentElement = arr.get(i);
            while (true) {
                int index = 0;
                int currentIndex = i;
                for (int j = 0; j < len; j++) {
                    if (currentIndex != j) {
                        if (arr.get(j) < currentElement) {
                            index++;
                        }
                    }
                }
                int temp = arr.get(index);
                arr.set(index, currentElement);
                currentElement = temp;
                currentIndex = index;
                circleArr.add(currentElement);
                if (index == i) {
                    break;
                }
            }
        }
    }
}
