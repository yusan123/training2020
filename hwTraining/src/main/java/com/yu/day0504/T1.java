package com.yu.day0504;


import java.util.*;

/**
 * @Author yu
 * @DateTime 2020/5/4 22:57
 *
 * 题目描述
 * 对字符串中的所有单词进行倒排。
 *
 * 说明：
 *
 * 1、构成单词的字符只有26个大写或小写英文字母；
 *
 * 2、非构成单词的字符均视为单词间隔符；
 *
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 *
 * 4、每个单词最长20个字母；
 *
 * 输入描述:
 * 输入一行以空格来分隔的句子
 *
 * 输出描述:
 * 输出句子的逆序
 *
 * 示例1
 * 输入
 * 复制
 * I am a student
 * 输出
 * 复制
 * student a am I
 */
public class T1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split("[^a-zA-Z]+");
        List<String> strings = Arrays.asList(s1);
        Collections.reverse(strings);
        StringJoiner joiner = new StringJoiner(" ");

        strings.stream().filter(x -> x.length()>0).forEach(x ->joiner.add(x));
        System.out.println(joiner);
    }

}
