package algorithm.array;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/3/16
 * @description leetcode [16] 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    /**
     * 思路：
     * 1. 利用三数之和的思路，但不同的是，
     * a. 只返回结果，且只有一个；
     * b. 判断的是target和sum最接近的那个结果；
     * 2. 每次存储，之后判断是否是最接近的，是则更新；
     * 时间复杂度：O(n^2) n 为数组长度
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(target - sum) < Math.abs(target - ans)) {
                    ans = sum;
                }
                if (target < sum) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int res = new ThreeSumClosest().threeSumClosest(new int[]{1,1,1,0}, 100);
        System.out.println(res);
    }
}
