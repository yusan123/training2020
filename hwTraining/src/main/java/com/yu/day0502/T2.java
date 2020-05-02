package com.yu.day0502;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author yu
 * @DateTime 2020/5/2 23:28
 * 按照指定规则对输入的字符串进行处理。
 * <p>
 * 详细描述：
 * <p>
 * 将输入的两个字符串合并。
 * <p>
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 * <p>
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 * <p>
 * <p>
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，排序后为“abcedf”，转换后为“5D37BF”
 * 输入描述:
 * 输入两个字符串
 * <p>
 * 输出描述:
 * 输出转化后的结果
 * <p>
 * 示例1
 * 输入
 * 复制
 * dec fab
 * 输出
 * 复制
 * 5D37BF
 */
public class T2 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            //while (sc.hasNextLine()) {
            String s = sc.nextLine().replaceAll(" ", "");
            if (s.isEmpty()) {
                return;
            }
            String[] sArr = s.split("");
            LinkedList<String> ouList = new LinkedList<>();
            LinkedList<String> jiList = new LinkedList<>();
            for (int i = 0; i < sArr.length; i++) {
                if (i % 2 == 0) {
                    ouList.add(sArr[i]);
                } else {
                    jiList.add(sArr[i]);
                }
            }
            Collections.sort(ouList);
            Collections.sort(jiList);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < sArr.length; i++) {
                if (i % 2 == 0) {
                    sb.append(ouList.removeFirst());
                } else {
                    sb.append(jiList.removeFirst());
                }
            }
            char[] chars = sb.toString().toCharArray();
            char[] result = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c <= 'F' && c >= 'A') {
                    c = (char) (c + 32);
                }
                if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f')) {
                    result[i] = getNewChar(c);
                } else {
                    result[i] = c;
                }
            }
            System.out.println(new String(result));
            //   }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static char getNewChar(char old) {
        String oldStr = new String(new char[]{old});
        int i1 = Integer.parseInt(oldStr, 16);
        String s = Integer.toBinaryString(i1);
        if (s.length() == 1) {
            s = "000" + s;
        }
        if (s.length() == 2) {
            s = "00" + s;
        }
        if (s.length() == 3) {
            s = "0" + s;
        }
        StringBuilder reverse = new StringBuilder(s).reverse();
        int i = Integer.parseInt(reverse.toString(), 2);
        String s1 = Integer.toHexString(i);
        s1 = s1.toUpperCase();
        return s1.toCharArray()[0];
    }
}
