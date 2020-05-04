package com.yu.sortingalgorithm;

/**
 * @Author yu
 * @DateTime 2020/5/4 23:11
 *
 * 在网上找的快排的代码
 */
public class QuickSort2 {

    private int partition(int[] a, int low, int high) {
        int pivot = a[low];
        while (low < high) {
            //从后往前开始比较，直到遇到比pivot小的数,将其移到low位置,此时high位置的数在[]中有两个
            while (low < high && a[high] >= pivot) {
                high--;
            }
            a[low] = a[high];

            //再从前开始比较，当然第一个a[low]是刚移过来的，low++,直到遇到比pivot小的数,将其替换到high位置的值
            while (low < high && a[low] <= pivot) {
                low++;
            }
            a[high] = a[low];
        }
        //遍历到后来low>high时，结束
        a[low] = pivot;
        return low;
    }

    public void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pivot = partition(data, low, high);
            quickSort(data, low, pivot - 1);

            quickSort(data, pivot + 1, high);

        }
    }

    public static void main(String[] args) {
        QuickSort2 t = new QuickSort2();
        //int[] a = {3, 2, 7, 10, 1, 9, 0, 5};
        int[] a = {3, 6, 2, 7, 1};
        t.quickSort(a, 0, a.length - 1);
        for (int i : a)
            System.out.print(i + " ");
    }
}
