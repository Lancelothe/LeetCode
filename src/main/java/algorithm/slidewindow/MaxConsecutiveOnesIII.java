package algorithm.slidewindow;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [1004] 最大连续1的个数 III
 * @difficulty Medium
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 *
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 *
 * 链接：https://leetcode-cn.com/problems/max-consecutive-ones-iii
 */
public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int res = 0;
        for (; right < A.length; right++) {
            if (A[right] == 0) {
                if (K > 0) {
                    K--;
                } else {
                    res = Math.max(res, right - left);
                    while (A[left++] == 1);
                }
            }
        }

        return Math.max(res, right - left);
    }

    public int longestOnes2(int[] A, int K) {
        int left = 0, right = 0;
        int res = 0;
        int cnt = 0;
        for (; right < A.length; right++) {
            if (A[right] == 0) cnt++;

                while (cnt > K) {
                    if (A[left] == 0) cnt--;
                    left++;
                }

            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MaxConsecutiveOnesIII().longestOnes2(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }

}
