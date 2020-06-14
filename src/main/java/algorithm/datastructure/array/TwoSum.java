package algorithm.datastructure.array;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2019/2/18
 * @description leetcode [1] 两数之和
 * @difficulty Easy
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 链接：https://leetcode-cn.com/problems/two-sum
 */
public class TwoSum {

    static class Solution {
        /**
         * 解法：
         *      1、对原整型数组对一个拷贝，操作此拷贝，对它进行排序；
         *      2、用快排的思路，前后两个指针分别从前和后靠近移动；
         *      3、因为是排序过的升序数组，所以数组第一位和最后一位相加相当于最小值+最大值，属于个中值，拿此值和目标值判断大小，如果大于目标值，则数组最后一位前移，否则数组首位后移。
         *      4、直到找到最小值+最大值=目标值 时，用此最小值和最大值找到在原数组中的索引。这里有两种情况：(1)如果最小值==最大值，则索引不能相同；(2)否则正常赋值到返回的数组里；
         *      5、最后对返回数组排序下，因为考虑数组是负数的情况，最大最小值是反的，即索引也会是反的。
         */
        public int[] twoSum(int[] nums, int target) {

            int[] numbers = Arrays.copyOf(nums, nums.length);
            if (numbers.length == 0) {
                return null;
            }

            int[] result = new int[2];
            Arrays.sort(numbers);
            int min = 0;
            int max = numbers.length - 1;
            while (min < max) {
                if (numbers[min] + numbers[max] > target) {
                    max--;
                } else if (numbers[min] + numbers[max] < target) {
                    min++;
                } else {
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[min] == numbers[max]) {
                            if (numbers[min] == nums[i] && result[0] == result[1]) {
                                result[0] = i;
                                continue;
                            }
                            if (numbers[max] == nums[i]) {
                                result[1] = i;
                            }
                        } else {
                            if (numbers[min] == nums[i]) {
                                result[0] = i;
                            }
                            if (numbers[max] == nums[i]) {
                                result[1] = i;
                            }
                        }
                    }
                    break;
                }

            }

            Arrays.sort(result);
            return result;
        }
    }

    public static void main(String[] args) {
        int[] a = {3,3};
        Solution solution = new Solution();
        int[] result = solution.twoSum(a, 6);
        System.out.println(Arrays.toString(result));

    }

    /*
     * @lc app=leetcode id=1 lang=java
     *
     * [1] Two Sum
     *
     * https://leetcode.com/problems/two-sum/description/
     *
     * algorithms
     * Easy (40.35%)
     * Total Accepted:    1.4M
     * Total Submissions: 3.5M
     * Testcase Example:  '[2,7,11,15]\n9'
     *
     * Given an array of integers, return indices of the two numbers such that they
     * add up to a specific target.
     *
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     *
     * Example:
     *
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     *
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     */
}

