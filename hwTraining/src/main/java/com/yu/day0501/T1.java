package com.yu.day0501;

import java.util.*;

/**
 * @Author yu
 * @DateTime 2020/5/1 14:56
 * 题目描述
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 注意每个输入文件有多组输入，即多个字符串用回车隔开
 * 输入描述:
 * 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
 * <p>
 * 输出描述:
 * 删除字符串中出现次数最少的字符后的字符串。
 * <p>
 * 示例1
 * 输入
 * 复制
 * abcdd
 * 输出
 * 复制
 * dd
 */
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            for (char c : chars) {
                map.put(c, map.get(c) == null ? 1 : map.get(c) + 1);
            }
            //使用map统计计算出现字符出现最少的次数是多少次
            Integer min = Collections.min(map.values());
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (entry.getValue() == min) {
                    //将所有出现最少次的字符移除掉
                    s = s.replaceAll(new String(new char[]{entry.getKey()}), "");
                }
            }
            System.out.println(s);
        }
    }
}
