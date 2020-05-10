package com.yu.day0429;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Administrator on 2020/4/29.
 * 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，
 * 下表就是一些主件与附件的例子：
 * 主件	附件
 * 电脑	打印机，扫描仪
 * 书柜	图书
 * 书桌	台灯，文具
 * 工作椅	无
 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。附件不再有从属于自己的附件。
 * 王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第 5 等最重要。
 * 他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N 元）的前提下，
 * 使每件物品的价格与重要度的乘积的总和最大。
 * 设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
 * v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
 * 请你帮助王强设计一个满足要求的购物单。
 * 输入描述:
 * 输入的第 1 行，为两个正整数，用一个空格隔开：N m
 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。
 * 如果 q=0 ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
 * 输出描述:
 * 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。
 * 示例1
 * 输入
 * 1000 5
 * 800 2 0
 * 400 5 1
 * 300 5 1
 * 400 3 0
 * 500 2 0
 * 输出
 * 2200
 */
public class T4 {
    public static void main(String[] args) {
        /**
         * todo : 给总钱数/10 商品数/10,最后结果乘以10,这样方便些
         */
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();

        String[] split = input1.split(" ");

        int v = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);

        int[] price = new int[n];
        int[] score = new int[n];
        int[] isMaster = new int[n];
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            price[i] = Integer.parseInt(s[0]);
            score[i] = Integer.parseInt(s[1]);
            isMaster[i] = Integer.parseInt(s[2]);
            items.add(new Item(price[i], score[i], isMaster[i]));
        }

        int i = getMaxValue(n, v, price, score, isMaster, items);
        System.out.println(i);
    }

    private static int getMaxValue(int n, int v, int[] price, int[] score, int[] isMaster, List<Item> items) {
        int[][] dp = new int[n + 1][v / 10 + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < (v / 10 + 1); j++) {
                //如果商品价格超过当前的钱，则为0
                if (price[i - 1] > j * 10) {
                    dp[i][j] = 0;
                } else {
                    //判断是不是主件物品
                    if (isMaster[i - 1] == 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - price[i - 1] / 10] + price[i - 1] / 10 * score[i - 1]);
                    } else {
                        //不是从件物品则取他的主件物品的索引
                        int masterIndex = isMaster[i - 1] - 1;
                        if (price[i - 1] + price[masterIndex] > j * 10) {
                            //主件物品和从件物品价值合超过总预算，则该件物品不能被加入到商品列表中
                            dp[i][j] = 0;
                        } else {
                            //比较上方的值和主+从+剩余钱在上一层的最大的结果
                            int upValue = dp[i - 1][j];

                            int masterPlusSelf = price[i - 1] / 10 * score[i - 1] + price[masterIndex] / 10 * score[masterIndex];
                            int rest = j - price[i - 1] / 10 - price[masterIndex] / 10;
                            //求直接取上一行剩余空间的最大值和
                            int maxRestValue = Math.max(dp[i - 1][rest], getMaxRestHaveMaster(rest, price[i - 1], isMaster[i - 1], items));
                            int upPlusZhuPlus = masterPlusSelf + maxRestValue;
                            dp[i][j] = Math.max(upValue, upPlusZhuPlus);
                        }
                    }
                }
            }
        }
        return dp[n][v / 10] * 10;
    }

    private static int getMaxRestHaveMaster(int rest, int curPrice, int isMaster, List<Item> items) {
        //求剩余空间可以装下的，从物品的最大价值
        List<Item> isSlave = items.stream().filter(i -> i.getIsMaster() == isMaster).collect(Collectors.toList());
        ArrayList<Item> isSlaveForRemove = new ArrayList<>(isSlave);
        for (Item item : isSlaveForRemove) {
            if (item.getPrice() == curPrice) {
                isSlave.remove(item);
                break;
            }
        }
        if (isSlave.isEmpty()) {
            return 0;
        }
        //去价值的最小值，用作while判断
        int min = isSlave.stream().mapToInt(Item::getPrice).min().getAsInt();
        if (min / 10 > rest) {
            return 0;
        }
        //对移除掉curPrice的从大到小排序
        List<Item> sortEd = isSlave.stream().sorted((x, y) -> {
            if (x.getPrice() * x.getScore() - y.getPrice() * y.getScore() == 0) {
                return 0;
            }
            return x.getPrice() * x.getScore() - y.getPrice() * y.getScore() > 0 ? -1 : 1;
        }).collect(Collectors.toList());

        ArrayList<Item> resList = new ArrayList<>();
        while (rest >= min / 10 && !sortEd.isEmpty()) {
            Item item = sortEd.get(0);
            sortEd.remove(0);
            resList.add(item);
            rest = rest - item.getPrice() / 10;
        }
        int sum = 0;
        for (Item re : resList) {
            sum += re.getPrice() / 10 * re.getScore();
        }
        return sum;
    }

    static class Item {
        int price;
        int score;
        int isMaster;

        public Item(int price, int score, int isMaster) {
            this.price = price;
            this.score = score;
            this.isMaster = isMaster;
        }

        public int getPrice() {
            return price;
        }

        public int getScore() {
            return score;
        }

        public int getIsMaster() {
            return isMaster;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "price=" + price +
                    ", score=" + score +
                    ", isMaster=" + isMaster +
                    '}';
        }
    }

}
