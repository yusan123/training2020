package com.yu.threadlock;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author yu
 * @DateTime 2020/5/15 15:19
 */
public class ReentrantLockTest1 {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        //默认创建的锁都是非公平锁
        System.out.println(lock.isFair());

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
    }
}
