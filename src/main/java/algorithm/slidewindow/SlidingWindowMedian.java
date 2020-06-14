package algorithm.slidewindow;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [480] 滑动窗口中位数
 * @difficulty Hard
 * 中位数是有序序列最中间的那个数。如果序列的大小是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 *
 * 例如：
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个大小为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 *
 * 示例：
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 *
 * 链接：https://leetcode-cn.com/problems/sliding-window-median
 */
public class SlidingWindowMedian {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        PriorityQueue<Double> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int index = 0;
        /**
         * 维持平衡 maxHeap[1....size-1] <= maxHeap[0] <= minHeap[0] <= minHeap[1....size-1]
         * 且保证 Math.abs(maxHeap.size()- minHeap.size()) <= 1
         */
        for (int i = 0; i < nums.length; i++) {
            minHeap.offer((double) nums[i]);

            //移除窗口外的值
            if (minHeap.size() + maxHeap.size() > k) {
                if (minHeap.contains((double) nums[i - k])) {
                    minHeap.remove((double) nums[i - k]);
                } else {
                    maxHeap.remove((double) nums[i - k]);
                }
            }
            //维持平衡
            if (minHeap.size() - maxHeap.size() > 1) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.size() > 0 && minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
                maxHeap.offer(minHeap.poll());
            }
            if (maxHeap.size() - minHeap.size() > 1) {
                minHeap.offer(maxHeap.poll());
            }

            //求窗口中间值
            if (minHeap.size() + maxHeap.size() == k) {

                if (minHeap.size() > maxHeap.size()) {
                    res[index++] = minHeap.peek();
                } else if (minHeap.size() < maxHeap.size()) {
                    res[index++] = maxHeap.peek();
                } else {
                    res[index++] = minHeap.peek() / 2.0d + maxHeap.peek() / 2.0d;
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }
}
