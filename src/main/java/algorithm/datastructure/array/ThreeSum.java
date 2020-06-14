package algorithm.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/3/16
 * @description leetcode [15] 三数之和
 * @difficulty Medium
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {

    /**
     * 思路：
     * 1. 对数组排序
     * 2. 左边负数，右边正数，则从数组两头开始用左边的负数+右边的正数是否为0：
     *      结果大于0，则说明正数太大，则左移正数；
     *      结果小于0，则说明负数太小，则右移负数；
     * 3. 需要注意的是，要跳过重复的元素
     * 时间复杂度：O(n^2) n 为数组长度
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (len < 3) return ans;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int res = nums[i] + nums[left] + nums[right];
                if (res > 0) {
                    right--;
                } else if (res < 0) {
                    left++;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(res);
    }
}
