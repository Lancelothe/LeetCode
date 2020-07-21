package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/7/11
 * @description leetcode [209] 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 *
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 *
 * 进阶：
 * 如果你已经完成了 O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 *
 * 链接：https://leetcode-cn.com/problems/minimum-size-subarray-sum
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length;
        int left = 0, right = 0;
        int max = Integer.MAX_VALUE;
        int sum = 0;

        while (right < length) {
            sum += nums[right];
            while (sum >= s) {
                max = Math.min(max, right - left + 1);
                sum -= nums[left];
                left++;

            }
            right++;
        }

        return max == Integer.MAX_VALUE ? 0 : max;
    }


    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}));
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(6, new int[]{10, 2, 3}));
    }
}
