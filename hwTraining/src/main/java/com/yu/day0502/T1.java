package com.yu.day0502;

import java.util.Scanner;

/**
 * @Author yu
 * @DateTime 2020/5/2 22:43
 * 题目描述
 * 1、对输入的字符串进行加解密，并输出。
 * <p>
 * 2加密方法为：
 * <p>
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * <p>
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * <p>
 * 其他字符不做变化。
 * <p>
 * 3、解密方法为加密的逆过程。
 * <p>
 * <p>
 * <p>
 * 接口描述：
 * <p>
 * 实现接口，每个接口实现1个基本操作：
 * <p>
 * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 * <p>
 * 说明：
 * <p>
 * 1、字符串以\0结尾。
 * <p>
 * 2、字符串最长100个字符。
 * <p>
 * <p>
 * <p>
 * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 * <p>
 * 说明：
 * <p>
 * 1、字符串以\0结尾。
 * <p>
 * 2、字符串最长100个字符。
 * 输入描述:
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 * <p>
 * 输出描述:
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 * <p>
 * 示例1
 * 输入
 * 复制
 * abcdefg
 * BCDEFGH
 * 输出
 * 复制
 * BCDEFGH
 * abcdefg
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String plainTxt = sc.nextLine();
            String encrypted = sc.nextLine();
            System.out.println(encrypt(plainTxt));
            System.out.println(decrypt(encrypted));
        }
    }

    public static String encrypt(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c >= 'a' && c < 'z') {
                result[i] = (char) (c - 31);
            } else if (c == 'z') {
                result[i] = 'A';
            } else if (c >= 'A' && c < 'Z') {
                result[i] = (char) (c + 33);
            } else if (c == 'Z') {
                result[i] = 'a';
            } else if (c >= '0' && c < '9') {
                result[i] = (char) (c + 1);
            } else if (c == '9') {
                result[i] = '0';
            } else {
                result[i] = c;
            }
        }
        return new String(result);
    }

    public static String decrypt(String s) {
        char[] chars = s.toCharArray();
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c > 'a' && c <= 'z') {
                result[i] = (char) (c - 33);
            } else if (c == 'a') {
                result[i] = 'Z';
            } else if (c > 'A' && c <= 'Z') {
                result[i] = (char) (c + 31);
            } else if (c == 'A') {
                result[i] = 'z';
            } else if (c > '0' && c <= '9') {
                result[i] = (char) (c - 1);
            } else if (c == '0') {
                result[i] = '9';
            } else {
                result[i] = c;
            }
        }
        return new String(result);
    }

}
