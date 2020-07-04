package com.yu.day0602;

import java.util.Scanner;

/**
 * @Author yu
 * @DateTime 2020/6/2 12:28
 * <p>
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 样例输入
 * <p>
 * 5
 * <p>
 * 样例输出
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * <p>
 * 输入描述:
 * 输入正整数N（N不大于100）
 * <p>
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 * <p>
 * 示例1
 * 输入
 * 4
 * 输出
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            int len = Integer.parseInt(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= len; i++) {
                int start = i * (i - 1) / 2 + 1;
                int step = i + 1;
                for (int j = 0; j < len - i + 1; j++) {
                    sb.append(start).append(" ");
                    start += step;
                    step++;
                }
                sb.setCharAt(sb.length() - 1, '\n');
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }
    }
}
