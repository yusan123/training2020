package com.yu.sortingalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yu
 * @DateTime 2020/5/4 23:11
 *
 * 快排方法quickSort()传入一个待排序的list
 *  quickSort()逻辑如下
 *      0.递归的跳出条件是集合中为0个或1个元素，不用再递归排序，直接返回即可
 *      1.取集合中第一个值作为基准值x
 *      2.把比基准值小的放入small集合，把比基准大的放入greater集合
 *      3.递归的调用quickSort(small)和quickSort(greater)
 *      4.返回quickSort(small)+基准值x+quickSort(greater) 使用addAll和add依次添加结果集合即可
 *
 * 时间复杂度O(n*logn)
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer[] arr = {213, 252, 12231, 3343, -10};
        System.out.println((quickSort(Arrays.asList(arr))));

    }

    private static List<Integer> quickSort(List<Integer> list) {
        if(list.size()<2){
            return list;
        }
        Integer jiZhu = list.get(0);
        List<Integer> small = list.stream().filter(x -> x < jiZhu).collect(Collectors.toList());
        List<Integer> greater = list.stream().filter(x -> x > jiZhu).collect(Collectors.toList());
        ArrayList<Integer> result = new ArrayList<>();
        result.addAll(quickSort(small));
        result.add(jiZhu);
        result.addAll(quickSort(greater));
        return result;
    }
}
