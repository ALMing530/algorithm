package com.wxm.sortingwitharraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//It will not work in an array which have repeated element
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
                continue;
            }
            int currentElement = arr.get(i);
            while (true) {
                int index = 0;
                for (int j = 0; j < len; j++) {
                    if (i != j) {
                        if (arr.get(j) < currentElement) {
                            index++;
                        }
                    }
                }
                int temp = arr.get(index);
                arr.set(index, currentElement);
                currentElement = temp;
                circleArr.add(currentElement);
                if (index == i) {
                    break;
                }
            }
        }
    }
}
