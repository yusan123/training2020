package com.yu.day0501;


        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;
        import java.util.Scanner;
        import java.util.stream.Collectors;

/**
 * @Author yu
 * @DateTime 2020/5/1 20:55
 * 题目描述
 * 信息社会，有海量的数据需要分析处理，比如公安局分析身份证号码、 QQ 用户、手机号码、银行帐号等信息及活动记录。
 * <p>
 * 采集输入大数据和分类规则，通过大数据分类处理程序，将大数据分类输出。
 * <p>
 * ﻿
 * 输入描述:
 * ﻿一组输入整数序列I和一组规则整数序列R，I和R序列的第一个整数为序列的个数（个数不包含第一个整数）；整数范围为0~0xFFFFFFFF，序列个数不限
 * <p>
 * 输出描述:
 * ﻿从R依次中取出R<i>，对I进行处理，找到满足条件的I<j>：
 * <p>
 * I<j>整数对应的数字需要连续包含R<i>对应的数字。比如R<i>为23，I<j>为231，那么I<j>包含了R<i>，条件满足 。
 * <p>
 * 按R<i>从小到大的顺序:
 * <p>
 * (1)先输出R<i>；
 * <p>
 * (2)再输出满足条件的I<j>的个数；
 * <p>
 * (3)然后输出满足条件的I<j>在I序列中的位置索引(从0开始)；
 * <p>
 * (4)最后再输出I<j>。
 * <p>
 * 附加条件：
 * <p>
 * (1)R<i>需要从小到大排序。相同的R<i>只需要输出索引小的以及满足条件的I<j>，索引大的需要过滤掉
 * <p>
 * (2)如果没有满足条件的I<j>，对应的R<i>不用输出
 * <p>
 * (3)最后需要在输出序列的第一个整数位置记录后续整数序列的个数(不包含“个数”本身)
 * <p>
 * <p>
 * <p>
 * 序列I：15,123,456,786,453,46,7,5,3,665,453456,745,456,786,453,123（第一个15表明后续有15个整数）
 * <p>
 * 序列R：5,6,3,6,3,0（第一个5表明后续有5个整数）
 * <p>
 * 输出：30, 3,6,0,123,3,453,7,3,9,453456,13,453,14,123,6,7,1,456,2,786,4,46,8,665,9,453456,11,456,12,786
 * <p>
 * 说明：
 * <p>
 * 30----后续有30个整数
 * <p>
 * 3----从小到大排序，第一个R<i>为0，但没有满足条件的I<j>，不输出0，而下一个R<i>是3
 * <p>
 * 6--- 存在6个包含3的I<j>
 * <p>
 * 0--- 123所在的原序号为0
 * <p>
 * 123--- 123包含3，满足条件
 * <p>
 * 示例1
 * 输入
 * 复制
 * 15 123 456 786 453 46 7 5 3 665 453456 745 456 786 453 123
 * 5 6 3 6 3 0
 * 输出
 * 复制
 * 30 3 6 0 123 3 453 7 3 9 453456 13 453 14 123 6 7 1 456 2 786 4 46 8 665 9 453456 11 456 12 786
 */
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String sI = sc.nextLine();
            String sR = sc.nextLine();
            StringBuilder result = new StringBuilder();
            String[] iArr = sI.split(" ");
            String[] rArr = sR.split(" ");
            List<String> iArrList = Arrays.asList(iArr);
            ArrayList<String> iList = new ArrayList<>(iArrList);
            //去掉I中第一个元素
            iList.remove(0);
            List<String> rArrList = Arrays.asList(rArr);
            ArrayList<String> rList = new ArrayList<>(rArrList);
            //去掉I中第一个元素
            rList.remove(0);
            //需要转换成数字去排序，否则4会大于21按照字符串比大小排序
            List<Integer> rListSorted = rList.stream().distinct().map(x -> Integer.parseInt(x)).sorted().collect(Collectors.toList());
            for (Integer r : rListSorted) {
                StringBuilder sb = new StringBuilder();
                int countMatch = 0;
                for (int i = 0; i < iList.size(); i++) {
                    if (iList.get(i).contains(r.toString())) {
                        countMatch++;
                        sb.append(i + " " + iList.get(i) + " ");
                    }
                }
                if (countMatch != 0) {
                    sb.insert(0, r + " " + countMatch + " ");
                }
                if (sb.length() != 0) {
                    result.append(sb);
                }
            }
            //空格的数量和元素的数量是相等的
            int num = result.length() - result.toString().replaceAll(" ", "").length();
            result.insert(0, num + " ");
            System.out.println(result);
        }
    }
}
