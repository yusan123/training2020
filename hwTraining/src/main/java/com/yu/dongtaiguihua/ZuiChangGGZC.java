package com.yu.dongtaiguihua;

import java.util.StringJoiner;

/**
 * @Author yu
 * @DateTime 2020/5/6 22:29
 * 求两个字符串的最长公共子串
 */
public class ZuiChangGGZC {

    public static void main(String[] args) {
        String s1 = "12mylove2liyyyyyyyasdas7777777444";
        String s2 = "3mylove2dyyyyyyydaaaasd7777777";
        //velij
        System.out.println(getMaxLength(s1, s2));
    }

    public static int getMaxLength(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        //求最长子串长度
        int maxLength = 0;
        int[][] temp = new int[s1Arr.length + 1][s2Arr.length + 1];
        for (int i = 1; i < s1Arr.length + 1; i++) {
            for (int j = 1; j < s2Arr.length + 1; j++) {
                if (s1Arr[i - 1] == s2Arr[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = 0;
                }
                if (temp[i][j] > maxLength) {
                    maxLength = temp[i][j];
                }
            }
        }
        StringJoiner sj = new StringJoiner(",", "最长子串都有： ", "");
        for (int i = 1; i < s1Arr.length + 1; i++) {
            for (int j = 1; j < s2Arr.length + 1; j++) {
                //如果一个点的值是最长的长度，那么从他开始往前的maxLength个字符就是最长子串
                if (temp[i][j] == maxLength) {
                    sj.add(s1.substring(i - maxLength, i));
                }
            }
        }
        System.out.println(sj);
        return maxLength;
    }
}
