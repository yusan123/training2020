package com.yu.day0429;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yu
 * @DateTime 2020/5/11 15:48
 */
public class Temp {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("a", "b", "1");
        List<String> subList = strings.subList(0, 1);
        System.out.println(subList);

    }
}
