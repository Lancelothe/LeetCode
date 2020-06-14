package algorithm.slidewindow;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [995] K 连续位的最小翻转次数
 * @difficulty Hard
 * 在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。
 * 返回所需的 K 位翻转的次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。
 *
 * 示例 1：
 * 输入：A = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 *
 * 示例 2：
 * 输入：A = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 *
 * 示例 3：
 * 输入：A = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 *
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-k-consecutive-bit-flips
 */
public class MinimumNumberOfKConsecutiveBitFlips {
    public int minKBitFlips(int[] A, int K) {
        int ans = 0;
        int right = 0;
        Queue<Integer> queue = new LinkedList<>();
        while (right < A.length) {
            if (!queue.isEmpty() && right - queue.peek() == K) {
                queue.poll();
            }

            //判断当前位置是否需要翻转
            if (queue.size() % 2 == A[right]) {
                if (right + K > A.length) return -1;
                ans++;
                queue.add(right);
            }
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new MinimumNumberOfKConsecutiveBitFlips()
//                .minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));

        System.out.println(new MinimumNumberOfKConsecutiveBitFlips()
                .minKBitFlips(new int[]{1,1,0}, 2));
    }
}
