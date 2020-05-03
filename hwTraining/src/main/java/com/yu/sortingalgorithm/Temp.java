package com.yu.sortingalgorithm;

import java.util.Arrays;
import java.util.List;

/**
 * @Author yu
 * @DateTime 2020/5/3 21:13
 */
public class Temp {
    public static void main(String[] args) {
        int[] arr1 = {1,3,32,22,11};
        Integer[] arr2 = {1,3,32,22,11};
        //基本类型的数组不能Arrays.asList直接转换为对应的list，因为不是包装类。
        // java包装类原理是擦拭法，泛型会被替换为Object，然后强转，基本类型不会
        List<int[]> ints = Arrays.asList(arr1);
        //引用类型的数组可以转换为列表
        List<Integer> integers = Arrays.asList(arr2);

        System.out.println(ints);
        System.out.println(integers);
    }
}
