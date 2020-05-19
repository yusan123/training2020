package com.yu.threadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author yu
 * @DateTime 2020/5/18 15:50
 */
public class ThreadPoolTest1 {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(10);

        //execute 只能接收runnable
        pool.execute(() ->{});

        //submit 既可以runnable又可以callable
        Future<?> submit = pool.submit(() -> {});
    }
}
