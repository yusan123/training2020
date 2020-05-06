package com.yu.dongtaiguihua;

/**
 * @Author yu
 * @DateTime 2020/5/6 22:29
 * 求两个字符串的最长公共子串
 */
public class ZuiChangGGZC {

    public static void main(String[] args) {
        String s1 = "mylovelijuandddddd1";
        String s2 = "mylovedddddd1yusevelijnzz";
        //velij
        System.out.println(getMaxLength(s1, s2));
    }

    public static int getMaxLength(String s1, String s2) {
        char[] s1Arr = s1.toCharArray();
        char[] s2Arr = s2.toCharArray();

        int[][] temp = new int[s1Arr.length + 1][s2Arr.length + 1];
        for (int i = 1; i < s1Arr.length + 1; i++) {
            for (int j = 1; j < s2Arr.length + 1; j++) {
                if (s1Arr[i - 1] == s2Arr[j - 1]) {
                    temp[i][j] = temp[i - 1][j - 1] + 1;
                } else {
                    temp[i][j] = 0;
                }
            }
        }
        int result = 0;
        int x = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s1Arr.length + 1; i++) {
            for (int j = 1; j < s2Arr.length + 1; j++) {
                if (temp[i][j] > result) {
                    result = temp[i][j];
                    x = i;
                }
            }
        }
        //求出最大子串长度是result,左边是x,y
        for (int i = result; i > 0; i--) {
            sb.insert(0, s1Arr[x - 1]);
            x--;
            if (x < 1) {
                break;
            }
        }
        System.out.println("最长子串是： " + sb);
        return result;
    }
}
