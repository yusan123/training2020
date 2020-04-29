package com.yu.day0429;

import java.util.Scanner;

/**
 * Created by Administrator on 2020/4/29.
 * 题目描述
 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。

 输入描述:
 输入一个整数（int类型）

 输出描述:
 这个数转换成2进制后，输出1的个数

 示例1
 输入
 复制
 5
 输出
 复制
 2
 */
public class T3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String i = Integer.toBinaryString(s);
        String s1 = i.replaceAll("1", "");
        System.out.println(i.length() - s1.length());

    }
}
