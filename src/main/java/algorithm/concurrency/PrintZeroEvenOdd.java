package algorithm.concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * @author lancelot
 * @date 2020/4/4
 * @description leetcode [1116] 打印零与奇偶数
 * 每个线程都有一个 printNumber 方法来输出一个整数。请修改给出的代码以输出整数序列 010203040506... ，其中序列的长度必须为 2n。
 */
public class PrintZeroEvenOdd {
    private int n;

    private volatile int start = 1;

    private volatile int who;
    private Lock lock = new ReentrantLock();
    private Condition zero = lock.newCondition();
    private Condition even = lock.newCondition();
    private Condition odd = lock.newCondition();

    public PrintZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (who != 0) {
                    zero.await();
                }
                printNumber.accept(0);
                if (start % 2 == 0) {
                    who = 2;
                    even.signal();
                } else {
                    who = 1;
                    odd.signal();
                }
                zero.await();
            }
            odd.signal();
            even.signal();
        } finally {
            lock.unlock();
        }
    }

    //偶数
    public void even(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (who != 2) {
                    even.await();
                } else {
                    printNumber.accept(start++);
                    who = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    //奇数
    public void odd(IntConsumer printNumber) throws InterruptedException {
        lock.lock();
        try {
            while (start <= n) {
                if (who != 1) {
                    odd.await();
                } else {
                    printNumber.accept(start++);
                    who = 0;
                    zero.signal();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintZeroEvenOdd p = new PrintZeroEvenOdd(2);

        new Thread(() -> {
            try {
                p.zero((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "1").start();
        new Thread(() -> {
            try {
                p.even((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "2").start();
        new Thread(() -> {
            try {
                p.odd((x) -> {
                    System.out.println(x + " " + Thread.currentThread().getName());
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "3").start();

    }
}
