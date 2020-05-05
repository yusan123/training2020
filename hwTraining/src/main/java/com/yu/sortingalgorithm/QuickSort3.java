package com.yu.sortingalgorithm;

import java.util.Arrays;

/**
 * @Author yu
 * @DateTime 2020/5/5 0:59
 */
public class QuickSort3 {

    public static void main(String[] args) {

        int[] arr = {4, -2, 1, 1, 9};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    //不能对重复的数排序
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int mid = getMidIndex(a, low, high);
            quickSort(a, low , mid - 1);
            quickSort(a, mid + 1, high);
        }
    }

    private static int getMidIndex(int[] a, int low, int high) {
        //取下标第一个作为中间基准值
        int mid = a[low];
        while (low < high) {
            //从后往前遍历，找到第一个大于中间值得索引
            while (low < high && a[high] > mid) {
                high--;
            }
            //将大于中间值放到mid左侧
            a[low] = a[high];
            //因为上一步执行，
            while (low < high && a[low] < mid) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = mid;
        return low;
    }


}
