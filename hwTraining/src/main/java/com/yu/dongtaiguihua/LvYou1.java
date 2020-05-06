package com.yu.dongtaiguihua;

/**
 * @Author yu
 * @DateTime 2020/5/6 22:05
 * <p>
 * 假设你有4天时间去陕西旅游，你没发去每个地方游览，因为你有如下列表
 * 名胜   时间  评分
 * 城墙   1    7
 * 陕博   1    6
 * 兵马俑  2   9
 * 法门寺 4    9
 * 大雁塔  1   8
 * <p>
 * 请根据此清单，计算出应该去哪些景点，评分总和最高
 */
public class LvYou1 {

    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[] times = {1, 1, 2, 4, 1};
        int[] score = {7, 6, 9, 9, 8};

        System.out.println(getShouldGo(m,n,times,score));
    }

    public static int getShouldGo(int m,int n,int[] t,int[] v){

        int[][] result = new int[m+1][n+1];
        //i描述的是m个景点去哪个
        for (int i = 1; i < m+1; i++) {
            //j表示的是1天两天三天。。。
            for (int j = 1; j < n+1; j++) {
                //表示当前的景点需要的时间，大于当前的j表示的时间，则不能去
                if(t[i-1]>j){
                    result[i][j] = result[i-1][j];
                }else{
                    result[i][j] = Math.max(result[i-1][j],result[i-1][j-t[i-1]]+v[i-1]);
                }
            }
        }

        int j = n;
        for (int i = m; i > 0; i--) {
            if(result[i][j]>result[i-1][j]){
                //说明该物品假如到了列表中去
                System.out.println(i-1);
                j-=t[i-1];
                if(j==0){
                    break;
                }
            }
        }
        return result[m][n];
    }
}
