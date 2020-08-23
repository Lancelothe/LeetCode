package algorithm.binarysearch;

/**
 * @author lancelot
 * @date 2020/8/22
 * @description 面试题 08.03. 魔术索引
 * @difficulty Easy
 * @tag 二分查找
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 * 输入：nums = [0, 2, 3, 4, 5]
 * 输出：0
 * 说明: 0下标的元素为0
 * 示例2:
 * 输入：nums = [1, 1, 1]
 * 输出：1
 * 说明:
 * nums长度在[1, 1000000]之间
 * 此题为原书中的 Follow-up，即数组中可能包含重复元素的版本
 *
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 */
public class FindMagicIndex {
    /**
     * 解法：跳跃遍历
     * 跳跃遍历即一下跳过不可能存在答案的区间去遍历数组
     * 证明：
     * nums： a b c ...n....x.....
     * index: 0 1 2 ...m....n.....
     * 如上情况，现在遍历到 index = m
     * 如果 n != m 并且 n < m 那么此时无法跳跃，只能index++继续遍历
     * 如果 n != m 并且 n > m 可以有一下结论：
     * 1. nums中n到x之间的数字nums[i]一定满足nums[i] >= n
     * 2.index中m到n之间的索引i一定满足m < i < n
     * 综合结论1、2有：
     * 索引i为(m, n)区间内的索引则一定满足： nums[i] >= n > i，换句话说索引i不可能为答案
     * 所以下一步直接跳跃至index = n = nums[m]
     */
    public int findMagicIndex(int[] nums) {
        int index = 0;
        while (index < nums.length) {
            if (index == nums[index]) return index;
            index = Math.max(index + 1, nums[index]);
        }
        return -1;
    }

    /**
     * 分治解法：左、中、右分别求解
     */
    public int findMagicIndexDivide(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }


}
