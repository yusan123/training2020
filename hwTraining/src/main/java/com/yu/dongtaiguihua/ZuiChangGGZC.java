package com.yu.dongtaiguihua;

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

        for (int i = 1; i < s1Arr.length + 1; i++) {
            for (int j = 1; j < s2Arr.length + 1; j++) {
                if (temp[i][j] == maxLength) {
                    StringBuilder sb = new StringBuilder();
                    int x = i;
                    for (int p = maxLength; p > 0; p--) {
                        sb.insert(0, s1Arr[x - 1]);
                        x--;
                        if(x<1){
                            break;
                        }
                    }
                    System.out.println(sb);
                }
            }
        }
        return maxLength;
    }
}
