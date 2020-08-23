package algorithm.binarysearch;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lancelot
 * @date 2020/3/16
 * @description leetcode [287] 寻找重复数
 * @difficulty Medium
 * @tag 二分查找、双指针
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 */
public class FindTheDuplicateNumber {

    /**
     * 解法一：HashSet去重
     */
    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for (int n : nums) {
            if (seen.contains(n)) {
                return n;
            }
            seen.add(n);
        }
        return -1;
    }

    /**
     * 解法二：二分法
     *
     * @param nums
     * @return
     */
    public static int findDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int length = nums.length;
        int left = 0, right = length - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            int cnt = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }

            if (cnt > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 4, 1, 1};
        System.out.println(findDuplicate(nums));
    }
}
