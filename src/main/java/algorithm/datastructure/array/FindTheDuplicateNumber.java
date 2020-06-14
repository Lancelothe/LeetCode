package algorithm.datastructure.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lancelot
 * @date 2020/3/16
 * @description leetcode [287] 寻找重复数
 * @difficulty Medium
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class FindTheDuplicateNumber {

    public static int findDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<Integer>();
        for(int n : nums) {
            if (seen.contains(n)) {
                return n;
            }
            seen.add(n);
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 4, 1, 1};
        System.out.println(findDuplicate(nums));
    }
}
