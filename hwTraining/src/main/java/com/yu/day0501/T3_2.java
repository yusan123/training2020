package com.yu.day0501;

import java.util.*;
import java.io.*;

/**
 * @Author yu
 * @DateTime 2020/5/2 0:06
 */
public class T3_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            String[] s = str.trim().split(" ");
            if (s.length < 4) {
                continue;
            }
            int num = Integer.parseInt(s[0]);
            if (num > 1000) {
                continue;
            }
            String key = s[num + 1];
            int index = Integer.parseInt(s[num + 2]);
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 1; i < s.length; i++) {
                if (isBroStr(s[i], key)) {
                    list.add(s[i]);
                }
            }
            System.out.println(list.size());
            Collections.sort(list);
            if (list.size() >= index) {
                System.out.println(list.get(index - 1));
            }
        }
    }

    public static boolean isBroStr(String source, String key) {
        if ((source.equals(key)) || (source.length() != key.length())) {
            return false;
        }
        for (int i = 'a'; i <= 'z'; i++) {
            char c = (char) i;
            if (getCharNum(source, c) != getCharNum(key, c)) {
                return false;
            }
        }
        return true;
    }

    public static int getCharNum(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }
}

