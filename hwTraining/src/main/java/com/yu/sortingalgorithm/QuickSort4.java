package com.yu.sortingalgorithm;
import java.util.Arrays;
/**
 * @Author yu
 * @DateTime 2020/5/6 0:07
 * 不使用list容器快速排序，但是不能排序包含重复元素的数组
 */
public class QuickSort4 {

    public static void main(String[] args) {
        int[] a = {3, -2, 10, 9, 22, 15};
        quickSort4(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
    public static void quickSort4(int[] a, int low, int high) {
        //不加这个条件，会导致递归无法跳出，栈内存溢出
        if (low < high) {
            int midIndex = getMidIndex(a, low, high);
            quickSort4(a, 0, midIndex - 1);
            quickSort4(a, midIndex + 1, high);
        }
    }
    private static int getMidIndex(int[] a, int low, int high) {
        //取low索引位置(也就是第一个值)作为中间值，基准值
        int mid = a[low];
        while (low < high) {
            //从右侧把小于mid的值的交换到左侧
            while (low < high && a[high] > mid) {
                high--;
            }
            a[low] = a[high];
            //从左侧把大于mid的值交换到右侧
            while (low < high && a[low] < mid) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = mid;
        return low;
    }
}
