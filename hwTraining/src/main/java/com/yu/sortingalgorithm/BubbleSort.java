package com.yu.sortingalgorithm;

import java.util.Arrays;

/**
 * @Author yu
 * @DateTime 2020/5/3 22:10
 * 冒泡排序第(从小到大)
 * <p>
 * 数组arr第i个元素和i+1比，如果arr[i]>arr[i+1],则交换他们.当前元素和下一个元素相比，如果大于他，则交换。
 * n个元素排序时，外层循环需要n-1次
 * 内层每次两个值比是n-1-外层循环的次数，因为外层循环每循环一次，就确定一个最大值。
 *
 * 假如有五个数排序，
 * 需要执行5-1次内循环冒泡出最大值，剩下那个肯定是最小值
 *  每次内循环5-1,五个数两两相比，比4次就可以比出最大值
 *  外循环每执行一次就可以确定一个最大值，内循环就可以少循环一次
 *
 *  时间复杂度(O(n^2))
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {213, 22, 12231, 3343, -10};
        System.out.println(Arrays.toString(select2(arr)));
    }

    public static int[] select2(int[] arr) {
        //n个数比n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            //每执行一次外循环就确定一个最大值，内循环就少循环一次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
}
