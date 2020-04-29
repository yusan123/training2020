package com.yu.day0429;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2020/4/29.
 * 题目描述
 给定n个字符串，请对n个字符串按照字典序排列。
 输入描述:
 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 输出描述:
 数据输出n行，输出结果为按照字典序排列的字符串。
 示例1
 输入
 复制
 9
 cap
 to
 cat
 card
 two
 too
 up
 boat
 boot
 输出
 复制
 boat
 boot
 cap
 card
 cat
 to
 too
 two
 up
 *
 */
public class T2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.nextLine();
        ArrayList<String> list = new ArrayList<>();
        for (int i1 = 0; i1 < i; i1++) {
            String s = sc.nextLine();
            list.add(s);
        }
       list.stream().sorted().forEach(x -> System.out.println(x));


    }

}
