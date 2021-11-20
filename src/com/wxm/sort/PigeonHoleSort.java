package com.wxm.sort;

import com.wxm.commons.Commons;

public class PigeonHoleSort {
    public static void main(String[] args) {
        int[] src = Commons.mockArray();
        Commons.printf(src);
        sort(src);
        Commons.printf(src);
    }
    public static void sort(int[] src){
        int max = Commons.max(src);
        int min = Commons.min(src);
        //鸽巢数
        int holeCount = max-min+1;
        int[] pigeonHole = new int[holeCount];
        for (int i : src) {
            pigeonHole[i-min]++;
        }
        int index = 0;
        for (int i = 0; i < pigeonHole.length; i++) {
            while (pigeonHole[i]>0){
                //索引即数值
                src[index++] = i+min;
                pigeonHole[i]--;
            }
        }
    }
}
