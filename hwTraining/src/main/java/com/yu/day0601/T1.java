package com.yu.day0601;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Author yu
 * @DateTime 2020/6/1 18:23
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * 的每段可以看成是一个0-255的整数，需要对IP地址进行校验
 * 输入描述:
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * <p>
 * 输出描述:
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * <p>
 * 示例1
 * 输入
 * 复制
 * 10.0.3.193
 * 167969729
 * 输出
 * 复制
 * 167773121
 * 10.3.3.193
 */
public class T1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("")) {
                return;
            }
            if (s.contains(".")) {
                String[] split = s.split("\\.");
                StringBuilder sb = new StringBuilder();
                for (String s1 : split) {
                    String s2 = Integer.toBinaryString(Integer.parseInt(s1));
                    sb.append(getBinString(s2, 8));
                }
                System.out.println(Long.parseLong(sb.toString(), 2));
            } else {
                String s1 = Long.toBinaryString(Long.parseLong(s));
                String binString = getBinString(s1, 32);
                StringJoiner sj = new StringJoiner(".");
                for (int i = 0; i < 4; i++) {
                    String substring = binString.substring(i * 8, (i + 1) * 8);
                    int i1 = Integer.parseInt(substring, 2);
                    sj.add(String.valueOf(i1));
                }
                System.out.println(sj);
            }
        }

    }

    public static String getBinString(String s, int len) {
        if (s.length() == len) {
            return s;
        } else {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < (len - s.length()); i++) {
                sb.insert(0, "0");
            }
            return sb.toString();
        }
    }

}
