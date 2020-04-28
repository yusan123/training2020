package com.yu.day0429;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * Created by Administrator on 2020/4/29.
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        sb.reverse();
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (String s : sb.toString().split("")) {
            set.add(Integer.parseInt(s));
        }
        StringBuilder sb2 = new StringBuilder();
        for (Integer integer : set) {
            sb2.append(integer);
        }

        System.out.println(sb2);

    }
}
