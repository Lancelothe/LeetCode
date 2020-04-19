package algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/18
 * @description leetcode [40] 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class CombinationSumII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (null == candidates || candidates.length == 0 || target < 0) return res;
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, new LinkedList<>());
        return res;
    }

    public void backtrack(int[] nums, int target, int index, LinkedList<Integer> path) {
        if (target < 0) return;

        if (target == 0) {
            res.add(new LinkedList<>(path));
        } else {
            for (int i = index; i < nums.length; i++) {
                if(index < i && nums[i] == nums[i-1]) continue;
                path.add(nums[i]);
                backtrack(nums, target - nums[i], i + 1, path);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new CombinationSumII().
                        combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)
        );
        // 1,1,2,5,6,7,10
    }
}
