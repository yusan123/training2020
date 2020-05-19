package com.yu.day0519;

/**
 * @Author yu
 * @DateTime 2020/5/19 13:22
 */
public class Singleton {

    private static volatile Singleton singleton;

    private Singleton(){};

    public static Singleton getInstance(){
        if(singleton == null){
            synchronized (Singleton.class){
                if(singleton == null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    public static void main(String[] args) {

        Singleton instance = getInstance();
        Singleton instance1 = getInstance();

        System.out.println(instance==instance1);
    }
}
