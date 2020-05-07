package com.yu.sortingalgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author yu
 * @DateTime 2020/5/4 23:11
 * <p>
 * 快排方法quickSort()传入一个待排序的list
 * quickSort()逻辑如下
 * 0.递归的跳出条件是集合中为0个或1个元素，不用再递归排序，直接返回即可
 * 1.取集合中第一个值作为基准值x
 * 2.把比基准值小的放入small集合，把相等的放入equal集合，把比基准大的放入greater集合
 * 3.递归的调用quickSort(small)和quickSort(greater)
 * 4.返回quickSort(small)+equal集合+quickSort(greater) 使用addAll依次添加结果集合即可
 * <p>
 * 时间复杂度O(n*logn)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1, 4, -2, 1, 1, 9, 9, -10};
        System.out.println(quickSort(arr));
    }

    private static List<Integer> quickSort(int[] arr) {
        List<Integer> list = new ArrayList<>(arr.length);
        Arrays.stream(arr).forEach(i -> list.add(i));
        return quickSort(list);
    }

    private static List<Integer> quickSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }
        Integer jiZhu = list.get(0);
        List<Integer> small = list.stream().filter(x -> x < jiZhu).collect(Collectors.toList());
        List<Integer> greater = list.stream().filter(x -> x > jiZhu).collect(Collectors.toList());
        List<Integer> equals = list.stream().filter(x -> x == jiZhu).collect(Collectors.toList());
        ArrayList<Integer> result = new ArrayList<>();
        //对左边小于的进行递归排序
        result.addAll(quickSort(small));
        //保存相同的值
        result.addAll(equals);
        //对右边的大于的进行递归排序
        result.addAll(quickSort(greater));
        return result;
    }
}
