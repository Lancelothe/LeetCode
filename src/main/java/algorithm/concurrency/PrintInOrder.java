package algorithm.concurrency;

/**
 * @author lancelot
 * @date 2020/4/4
 * @description leetcode [1114] 按序打印
 * 三个不同的线程将会共用一个 Foo 实例。 按顺序执行三个线程
 */
public class PrintInOrder {
    private boolean firstFinished;
    private boolean secondFinished;
    private Object lock = new Object();


    public PrintInOrder() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            lock.notifyAll();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstFinished) {
                lock.wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondFinished) {
                lock.wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
