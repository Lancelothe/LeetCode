package algorithm.concurrency;

/**
 * @author lancelot
 * @date 2020/4/4
 * @description leetcode [1115] 交替打印FooBar
 */
public class PrintFooBarAlternately {
    private int n;
    private boolean fooTurn = true;
    private Object lock = new Object();

    public PrintFooBarAlternately(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (!fooTurn) lock.wait();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooTurn = false;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                if (fooTurn) lock.wait();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooTurn = true;
                lock.notifyAll();
            }
        }
    }
}
