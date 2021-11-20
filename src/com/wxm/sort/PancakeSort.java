package com.wxm.sort;

import com.wxm.commons.Commons;

public class PancakeSort {
    public static void main(String[] args) {
        int[] src = Commons.mockArray();
        Commons.printf(src);
        sort(src);
        Commons.printf(src);
    }

    public static void sort(int[] src) {
        int length = src.length;
        for (int i = 0; i < length; i++) {
            //正序用 min 倒序 用 max
            int indexOfMin = indexOfMin(src, i);
            //将最小值（或最大值）反转到数组尾部
            flip(src, indexOfMin, length - 1);
            //将尾部元素反转到数组首部（随着循环的进行，首部逐步后移。即以排序的元素排除在外）
            flip(src, i, length - 1);
        }
    }

    /**
     * 查询数组中最大元素索引
     * @param src 源数组
     * @param start 查找开始位置，start 前的元素不参与查找
     * @return 数组中组大元素的索引
     */
    public static int indexOfMax(int[] src, int start) {
        int index = start;
        int max = src[start];
        for (int i = start+1; i < src.length; i++) {
            if (src[i] > max) {
                index = i;
                max = src[i];
            }
        }
        return index;
    }
    /**
     * 查询数组中最小元素索引
     * @param src 源数组
     * @param start 查找开始位置，start 前的元素不参与查找
     * @return 数组中组小元素的索引
     */
    public static int indexOfMin(int[] src, int start) {
        int index = start;
        int min = src[start];
        for (int i = start+1; i < src.length; i++) {
            if (src[i] < min) {
                index = i;
                min = src[i];
            }
        }
        return index;
    }

    /**
     * 根据给定起始与结束位置反转起始到结束位置的元素
     * @param src 源数组
     * @param start 反转开始位置
     * @param end 反转结束位置
     */
    public static void flip(int[] src, int start, int end) {
        for (int i = 0; i < (end - start) / 2 + 1; i++) {
            //start + i 和 end - i 相等说明总和为奇数。当前位置为中位。不需要交换
            if ((start + i) != (end - i)) {
                Commons.swap(src, start + i, end - i);
            }
        }
    }
}
