package algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/19
 * @description leetcode [47] 全排列II
 * @difficulty Medium
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 */
public class PermutationsII {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new LinkedList<>());
        return res;
    }

    private void backtrack(int[] nums, boolean[] visited, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }

                visited[i] = true;
                path.add(nums[i]);
                backtrack(nums, visited, path);
                path.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new PermutationsII()
                        .permuteUnique(new int[]{1, 1, 2})
        );
    }
}
