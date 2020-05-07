package com.yu.dynamicprogramming;

import java.util.StringJoiner;

/**
 * @Author yu
 * @DateTime 2020/5/6 22:29
 * 求两个字符串的最长公共子串
 */
public class MaxLengthCommonSubString {

    public static void main(String[] args) {
        String s1 = "12mylove2liyyyyyyyasdas7777777444";
        String s2 = "3mylove2dyyyyyyydaaaasd7777777";
        System.out.println(getMaxLength(s1, s2));
    }

    public static int getMaxLength(String s1, String s2) {

        //求最长子串长度
        int maxLength = 0;
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                if (dp[i][j] > maxLength) {
                    maxLength = dp[i][j];
                }
            }
        }
        StringJoiner sj = new StringJoiner(",", "最长子串都有： ", "");
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                //如果一个点的值是最长的长度，那么从他开始往前的maxLength个字符就是最长子串
                if (dp[i][j] == maxLength) {
                    sj.add(s1.substring(i - maxLength, i));
                }
            }
        }
        System.out.println(sj);
        return maxLength;
    }
}
