package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/2/6
 * @description leetcode [485] 最大连续1的个数
 * @difficulty Easy
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int n : nums) {
            cur = n == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
