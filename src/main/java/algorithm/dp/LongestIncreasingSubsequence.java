package algorithm.dp;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/8/22
 * @description leetcode [300] 最长上升子序列
 * @difficulty Medium
 * @tag 二分查找、动态规划
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 *
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[] {1, 4, 3, 4, 2, 5}));
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(new int[] {1,3,6,7,9,4,10,5,6}));
    }
}
