package com.wxm.search;
/**
 *
 * 功能描述:暴力查找
 * @Description
 * @ClassName ForceSearch
 * @auther: ALMing
 * @date: 2020/4/5 14:03

 *
 */
public class ForceSearch {
    public static void main(String[] args) {
        int[] array = {13, 3, 5, 7, 4, 8, 43, 78, 9, 377, 23, 47, 67, 2, 11};
        int dist = search(array, 23);
        System.out.format("\33[1;34m%d", dist);
    }

    private static int search(int[] array, int element) {
        int dist = -1;
        for (int value : array) {
            if (element == value) {
                dist = value;
                break;
            }
        }
        return dist;
    }
}
