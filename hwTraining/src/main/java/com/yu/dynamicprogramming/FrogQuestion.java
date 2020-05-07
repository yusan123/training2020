package com.yu.dynamicprogramming;

/**
 * @Author yu
 * @DateTime 2020/5/7 22:46
 *
 * 一只青蛙可以一次跳1层或者2层台阶，问跳10(n)层台阶共有多少种跳法？
 * dp[i] 表示跳到i层最多有dp[i]种方案
 * 最后一次跳，只有两种情况，一种是从n-1层跳一层到n,另外一种是从n-2跳2层到n层
 * 而跳到n-1共有dp[n-1]种方案,跳到n-2总共dp[n-2]种方案
 *
 * 所以dp[n] = dp[n-1]+dp[n-2]
 */
public class FrogQuestion {
    public static void main(String[] args) {
        //总的台阶数
        int n = 10;
        int i = getSchemeNum(4);
        System.out.println(i);
    }

    private static int getSchemeNum(int n) {
        //
        int[] dp = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            /**
             * 0层有0种
             * 1层有一种 1
             * 2层有两种 1+1 2
             */
            if(i<3){
                dp[i] = i;
            }else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
}
