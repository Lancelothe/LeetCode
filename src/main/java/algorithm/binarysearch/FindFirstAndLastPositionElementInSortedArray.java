package algorithm.binarysearch;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/4/19
 * @description leetcode [34] 在排序数组中查找元素的第一个和最后一个位置 & 剑指 Offer 53 - I. 在排序数组中查找数字 I
 * @difficulty Medium
 * @tag 二分查找
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class FindFirstAndLastPositionElementInSortedArray {

    /**
     * 思路：
     * 分别找最左侧的点和最右侧的点，如果右侧的点索引小于左侧的点的索引则说明不存在。
     */
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (null == nums || nums.length == 0) return res;

        res[0] = searchLeftBound(nums, target);
        res[1] = searchRightBound(nums, target);
        return res[1] < res[0] ? new int[]{-1, -1} : res;
    }

    private int searchLeftBound(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return left;
    }

    private int searchRightBound(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new FindFirstAndLastPositionElementInSortedArray()
                                .searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)
                )
        );
    }
}
