package algorithm.datastructure.stack;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author lancelot
 * @date 2020/6/30
 * @description leetcode [232] 用栈实现队列 & 剑指 Offer 09. 用两个栈实现队列
 * @difficulty Easy
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 * 示例:
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 *
 * 链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(3);
        queue.appendTail(4);
        queue.appendTail(5);
        System.out.println(queue);
        queue.deleteHead();
        System.out.println(queue);
    }

}

class MyQueue{

    Stack<Integer> s1;
    Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

/**
 * 剑指Offer题：
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 示例 1：
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 *
 * 示例 2：
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
class CQueue {

    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;
    public CQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "CQueue{" +
                "stack1=" + stack1 +
                ", stack2=" + stack2 +
                '}';
    }

    public void appendTail(int value) {
        stack1.add(value);
    }

    public int deleteHead() {
        int res = -1;
        if (!stack1.isEmpty()) {
            if (stack1.size() > 1) {
                int size = stack1.size() - 1;
                for (int i = 0; i < size; i++) {
                    Integer tmp = stack1.pollLast();
                    stack2.add(tmp);
                }
            }
            res = stack1.remove();
        }

        if (!stack2.isEmpty()) {
            int size = stack2.size();
            for (int i = 0; i < size; i++) {
                Integer tmp = stack2.pollLast();
                stack1.add(tmp);
            }
        }

        return res;
    }

}
