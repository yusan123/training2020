package com.yu.day0429;

import java.util.*;

/**
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * <p>
 * <p>
 * 处理：
 * <p>
 * <p>
 * 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
 * <p>
 * <p>
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * <p>
 * <p>
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * <p>
 * <p>
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * <p>
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 * <p>
 * 示例1
 * 输入
 * 复制
 * E:\V1R2\product\fpgadrive.c   1325
 * 输出
 * 复制
 * fpgadrive.c 1325 1
 */
public class T6 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> res = new LinkedHashMap<>();
        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            //说明不是正常要处理的数据
            if(s.length!=2){
                break;
            }
            String fileName = getFileName(s[0]);
            String key = fileName + " " + s[1];
            Integer value = res.get(key) == null ? 1 : res.get(key) + 1;
            res.put(key, value);
        }
        int count=0;
        for (String s : res.keySet()) {
            count++;
            if(count>res.size()-8)
                System.out.println(s + " " + res.get(s));
        }
    }
    public static String getFileName(String all) {
        String s = all.substring(all.lastIndexOf("\\")+1);
        if (s.length() > 16) {
            return s.substring(s.length() - 16);
        }
        return s;
    }

}