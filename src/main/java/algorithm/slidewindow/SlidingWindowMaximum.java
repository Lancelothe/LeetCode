package algorithm.slidewindow;

import java.util.LinkedList;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [239]
 * @difficulty Hard
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 *
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 */
public class SlidingWindowMaximum {

    /**
     * 对于滑动窗口的复杂度问题，一直疑惑为什么是O(n)，里面明明还有个while循环。
     * labuladong大神的通俗解释是:
     * 这个算法的时间复杂度是 O(M + N)，M 和 N 分别是字符串 S 和 T 的长度。因为我们先用 for 循环遍历了字符串 T 来初始化 needs，时间 O(N)，之后的两个 while 循环最多执行 2M 次，时间 O(M)。
     * 读者也许认为嵌套的 while 循环复杂度应该是平方级，但是你这样想，while 执行的次数就是双指针 left 和 right 走的总路程，最多是 2M 嘛。
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> maxQueue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] <= nums[i]) {
                maxQueue.pollLast();
            }
            // 添加当前值对应的数组下标
            maxQueue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if (maxQueue.peek() <= i - k) {
                maxQueue.poll();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[maxQueue.peek()];
            }
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3));
        System.out.println(new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, -1}, 1));
    }
}
