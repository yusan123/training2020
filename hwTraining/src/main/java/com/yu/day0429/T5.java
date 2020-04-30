package com.yu.day0429;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 题目描述
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：
 * <p>
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * <p>
 * 坐标之间以;分隔。
 * <p>
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * <p>
 * 下面是一个简单的例子 如：
 * <p>
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * <p>
 * 处理过程：
 * <p>
 * 起点（0,0）
 * <p>
 * +   A10   =  （-10,0）
 * <p>
 * +   S20   =  (-10,-20)
 * <p>
 * +   W10  =  (-10,-10)
 * <p>
 * +   D30  =  (20,-10)
 * <p>
 * +   x    =  无效
 * <p>
 * +   A1A   =  无效
 * <p>
 * +   B10A11   =  无效
 * <p>
 * +  一个空 不影响
 * <p>
 * +   A10  =  (10,-10)
 * <p>
 * 结果 （10， -10）
 * <p>
 * 注意请处理多组输入输出
 * <p>
 * 输入描述:
 * 一行字符串
 * <p>
 * 输出描述:
 * 最终坐标，以,分隔
 * <p>
 * 示例1
 * 输入
 * 复制
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * 输出
 * 复制
 * 10,-10
 */
public class T5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(";");

            List<String> right = Arrays.stream(split).filter(x -> x.matches("[ASWD]\\d+")).collect(Collectors.toList());

            int[] result = {0, 0};

            for (String s : right) {
                String direction = s.substring(0, 1);
                Integer distance = Integer.parseInt(s.substring(1));
                switch (direction) {
                    case "A":
                        result[0] = result[0] - distance;
                        break;
                    case "D":
                        result[0] = result[0] + distance;
                        break;
                    case "S":
                        result[1] = result[1] - distance;
                        break;
                    case "W":
                        result[1] = result[1] + distance;
                        break;
                    default:
                        throw new RuntimeException("ssssss");
                }
            }
            System.out.println(result[0] + "," + result[1]);
        }
    }
}
