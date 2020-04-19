package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/18
 * @description leetcode [39] 数组总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class CombinationSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
                if (target < nums[i]) break;
                path.add(nums[i]);
                backtrack(nums, target - nums[i], i, path);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
