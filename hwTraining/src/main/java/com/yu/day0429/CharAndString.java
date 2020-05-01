package com.yu.day0429;

/**
 * @Author yu
 * @DateTime 2020/5/1 13:56
 */
public class CharAndString {

    public static void main(String[] args) {

        //字符取之后一个字符
        char a = 'a';
        System.out.println((char)('a'+1));

        //单字母字符串转字符
        String x = "x";
        char cx = x.toCharArray()[0];
        System.out.println("字符串x: "+x);
        System.out.println("字符x: "+cx);

        //单字符转字符串
        char p = 'p';
        String sp = new String(new char[]{p});
        System.out.println("字符串p: "+sp);
        System.out.println("字符: "+p);
    }
}
