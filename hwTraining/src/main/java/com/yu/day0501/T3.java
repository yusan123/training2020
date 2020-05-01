package com.yu.day0501;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author yu
 * @DateTime 2020/5/1 22:38
 * 输入描述:
 * 先输入字典中单词的个数，再输入n个单词作为字典单词。
 * 输入一个单词，查找其在字典中兄弟单词的个数
 * 再输入数字n
 *
 * 输出描述:
 * 根据输入，输出查找到的兄弟单词的个数
 *
 * 示例1
 * 输入
 * 复制
 * 3 abc bca cab abc 1
 * 输出
 * 复制
 * 2
 * bca
 */
public class T3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int num = Integer.parseInt(s1[0]);
            ArrayList<String> dataList = new ArrayList<>();
            for (int i = 1; i <= num; i++) {
                dataList.add(s1[i]);
            }
            String searchKey = s1[num + 1];
            Integer broIndex = Integer.parseInt(s1[num + 2]);

            ArrayList<String> litTemp = new ArrayList<>(dataList);
            for (String s2 : litTemp) {
                if(!getSortedStr(s2).equals(getSortedStr(searchKey))){
                    dataList.remove(s2);
                }
            }
            dataList.remove(searchKey);
            List<String> distinctList = dataList.stream().sorted().distinct().collect(Collectors.toList());
            System.out.println(distinctList.size());
            if(broIndex>=1 && broIndex<=distinctList.size()){
                System.out.println(distinctList.get(broIndex-1));
            }
        }
    }

    public static String getSortedStr(String s){
        char[] chars = s.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        for (char aChar : chars) {
            list.add(new String(new char[]{aChar}));
        }

        return list.stream().sorted().collect(Collectors.joining(""));
    }

}
