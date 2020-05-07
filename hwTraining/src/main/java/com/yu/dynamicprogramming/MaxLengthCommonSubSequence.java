package com.yu.dynamicprogramming;

/**
 * @Author yu
 * @DateTime 2020/5/7 22:37
 * <p>
 * 求最长公共子序列
 * apple
 * able  ==> ale
 */
public class MaxLengthCommonSubSequence {

    public static void main(String[] args) {
        String s1 = "3appl2yue";
        String s2 = "2abl3e333yu";
        int i = getMaxCommonSubSequence(s1, s2);
        System.out.println(i);
    }

    private static int getMaxCommonSubSequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    //如果相等就是左上角数加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] != Math.max(dp[i - 1][j], dp[i][j - 1])) {
                        //说明该公共子序列没有被添加过
                        sb.append(s1.charAt(i - 1));
                    }
                } else {
                    //否则就是上方或者左侧最大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println("最长公共子序列是： " + sb);
        return sb.length();
    }
}
