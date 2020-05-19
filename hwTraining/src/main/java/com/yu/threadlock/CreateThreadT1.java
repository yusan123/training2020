package com.yu.threadlock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author yu
 * @DateTime 2020/5/19 12:58
 */
public class CreateThreadT1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> integerFutureTask = new FutureTask<Integer>(new T1());

        Thread thread = new Thread(integerFutureTask);
        thread.start();
        Integer integer = integerFutureTask.get();
        System.out.println(integer);

    }


}

class T1 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        return 111;
    }
}
