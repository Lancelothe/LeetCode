package algorithm.datastructure.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [532] 数组中的K-diff数对
 * @difficulty Easy
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 */
public class KDiffPairsInArray {

    // Hash法
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Set<Integer> diff = new HashSet<>(), raw = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (raw.contains(nums[i] + k)) {
                diff.add(nums[i] + k);
            }
            if (raw.contains(nums[i] - k)) {
                diff.add(nums[i]);
            }
            raw.add(nums[i]);
        }
        return diff.size();
    }

    // 排序+遍历法
    public int findPairs2(int[] nums, int k) {
        if(k < 0) return 0;
        Arrays.sort(nums);
        int start = 0, count = 0, prev = 0x7fffffff;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] - nums[start] > k || prev == nums[start]) {
                if (++start != i) i--;
            }else if (nums[i] - nums[start] == k) {
                prev = nums[start++];
                count++;
            }
        }
        return count;
    }
}
