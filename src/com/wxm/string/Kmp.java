package com.wxm.string;

import java.util.Arrays;
/**
 *
 * 功能描述:kmp算法的java实现
 * @Description
 * @ClassName Kmp
 * @auther: ALMing
 * @date: 2020/4/5 14:02

 *
 */
public class Kmp {
    public static void main(String[] args) {
        String str = "ACBABABDDABDABABCBCABDDBABAB";
        String pattern = "ABABC";
        char[] s = str.toCharArray();
        char[] p = pattern.toCharArray();
        int kmp = kmp(s, p);
        System.out.format("\33[1;34m匹配元素起始索引：%d", kmp);

    }

    public static int kmp(char[] s, char[] p) {
        int index = -1;
        int sLen = s.length;
        int pLen = p.length;
        int sIndex = 0;
        while (sIndex != sLen) {
            int match = 0;
            int stempSIndex = sIndex;
            //如果查到倒数pLen个字符还没找到匹配就不用继续向后移位了因为s的剩余元素长度小与p不可能找到相匹配的元素
            if (stempSIndex + pLen > sLen) {
                break;
            }
            for (char c : p) {
                if (c == s[stempSIndex]) {
                    stempSIndex++;
                    match++;
                } else {
                    char[] chars = Arrays.copyOfRange(p, 0, match);
                    int partitionMatch = getMoveStep(chars);
                    sIndex += partitionMatch;
                    break;
                }
            }
            //如果匹配长度等于pattern说明已经找到匹配元素
            if (match == pLen) {
                index = sIndex;
                break;
            }
        }
        return index;
    }

    public static int getMoveStep(char[] chars) {
        int len = chars.length;
        //最大公共元素长度，从最长的开始试
        int times = len - 1;
        while (times > 0) {
            int match = 0;
            for (int i = 0; i < times; i++) {
                if (chars[i] == chars[len - times + i]) {
                    match++;
                } else {
                    break;
                }
            }
            //如果匹配次数等于假定的最大公共元素长度，则说明匹配成功。此时times即是最长公共元素长度
            if (times == match) {
                break;
            }
            times--;
        }
        //使用公共元素长度减最大公共元素长度，即为查找下一次移位需要移动的步数
        return len - times;
    }
}
