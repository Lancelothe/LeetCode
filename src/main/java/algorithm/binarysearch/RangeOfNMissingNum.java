package algorithm.binarysearch;

/**
 * @author lancelot
 * @date 2020/8/22
 * @description 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * @difficulty Easy
 * @tag 二分查找
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 示例 1:
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 *
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 */
public class RangeOfNMissingNum {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int length = nums.length;
        int left = 0, right = length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}