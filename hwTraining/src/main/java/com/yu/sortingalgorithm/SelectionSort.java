package com.yu.sortingalgorithm;

import java.util.Arrays;

/**
 * @Author yu
 * @DateTime 2020/5/3 20:51
 * <p>
 * 从小到大排序
 * 依次从0到最后选择出最小值放到0号位置，1到最后选出最小值放到1号位置，2到最后选择最小值放2号位置...完成排序
 * <p>
 * O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {213, 22, 12231, 3343, -10};
        System.out.println(Arrays.toString(select2(arr)));

    }

    public static int[] select2(int[] arr) {
        //最后一次循环肯定是最大值，所以可以少循环一次
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                //求出最小值索引
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            //依次修改原数组位置的值替换为最小值
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }
}
