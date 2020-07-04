package com.yu.day0610;

/**
 * @Author yu
 * @DateTime 2020/6/10 17:08
 * 输入给定四个字符串，是四个点的坐标。求这四个点是否可以组成一个正方形，返回布尔值。
 * 输入：
 * （0，1）
 * （0，0）
 * （1，2）
 * （2，2）
 * 输出：
 * false
 */
public class T1 {

    public static void main(String[] args) {
        double[] a = {0, 1};
        double[] b = {0, 0};
        double[] c = {1, 2};
        double[] d = {2, 2};
        System.out.println(isRectangle(a, b, c, d));
    }

    public static double getDistance(double[] a, double[] b) {
        //距离的平方
        return Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2);
    }

    public static boolean isRectangle(double[] a, double[] b, double[] c, double[] d) {
        double xCenter = (a[0] + b[0] + c[0] + d[0]) / 4;
        double yCenter = (a[1] + b[1] + c[1] + d[1]) / 4;

        double[] center = {xCenter, yCenter};

        double dA = getDistance(a, center);
        double dB = getDistance(b, center);
        double dC = getDistance(c, center);
        double dD = getDistance(d, center);
        return dA == dB && dA == dC && dA == dD;
    }
}
