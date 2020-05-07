package com.yu.dynamicprogramming;

/**
 * @Author yu
 * @DateTime 2020/5/6 21:32
 * <p>
 * 有一个小偷有一个包可以装4kg的商品
 * 音响 3000块 4kg
 * 笔记本电脑 2000 3kg
 * 吉他 1500 1kg
 */
public class Bags1 {

    public static void main(String[] args) {
        int c = 4;
        int n = 4;
        String[] p = {"音响", "笔记本电脑", "吉他", "iPhone"};
        int[] v = {3000, 2000, 1500, 2000};
        int[] w = {4, 3, 1, 1};
        System.out.println(getMaxValue(c, n, v, w, p));
    }

    public static int getMaxValue(int c, int n, int[] v, int[] w, String[] p) {
        int[][] dp = new int[n + 1][c + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                if (w[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }
        int j = c;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i > 0; i--) {
            if (dp[i][j] > dp[i - 1][j]) {
                //添加了该物品
                stringBuilder.insert(0, p[i - 1] + ",");
                j = j - w[i - 1];
                if (j == 0) {
                    break;
                }
            }
        }
        System.out.println(stringBuilder);
        return dp[n][c];
    }
}
