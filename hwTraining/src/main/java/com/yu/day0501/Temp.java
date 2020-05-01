package com.yu.day0501;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author yu
 * @DateTime 2020/5/1 22:35
 */
public class Temp {

    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        list.add("bac");
        list.add("cba");
        list.add("acb");
        Collections.sort(list);
        System.out.println(list);
    }
}
