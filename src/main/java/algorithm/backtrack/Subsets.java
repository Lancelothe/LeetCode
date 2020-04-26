package algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/21
 * @description leetcode [78] 子集
 * @difficulty Medium
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/subsets
 */
public class Subsets {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (null == nums || nums.length == 0) return res;

        backtrack(nums, 0, new LinkedList<>());
        return res;
    }

    public void backtrack(int[] nums, int start, LinkedList<Integer> path) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Subsets()
                        .subsets(new int[]{1, 2, 3})
        );
    }

}
