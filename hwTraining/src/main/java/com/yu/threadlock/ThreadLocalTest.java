package com.yu.threadlock;

/**
 * @Author yu
 * @DateTime 2020/5/19 11:34
 */
public class ThreadLocalTest {

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    static void print(){
        String s = threadLocal.get();

        System.out.println("current:"+Thread.currentThread().getName()+" value is:"+s);
        threadLocal.remove();
    }

    public static void main(String[] args) {

        Runnable r1 = () -> {
            threadLocal.set(Thread.currentThread().getName());
            print();
            System.out.println("after remove: "+threadLocal.get());
        };
//        Runnable r2 = () -> {
//            threadLocal.set("r2SetValue");
//            print();
//            System.out.println("after r2 remove: "+threadLocal.get());
//        };

        Thread t1 = new Thread(r1, "t1");
        Thread t2 = new Thread(r1, "t2");

        t1.start();
        t2.start();

    }
}
