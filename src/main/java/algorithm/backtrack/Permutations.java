package algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/19
 * @description leetcode [46] 全排列
 * @difficulty Medium
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/permutations
 */
public class Permutations {

    List<List<Integer>> res = new ArrayList<>();
    /**
     * boolean[]记录访问过的坐标
     */
    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) return res;
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
                visited[i] =true;
                path.add(nums[i]);
                backtrack(nums, visited, path);
                path.removeLast();
                visited[i] =false;
            }
        }
    }

// =============================================================================
    // 没有剪枝，只在遍历时判断去重if (path.contains(nums[i])) continue;
//    public List<List<Integer>> permute(int[] nums) {
//        if (null == nums || nums.length == 0) return res;
//        backtrack(nums, new LinkedList<>());
//        return res;
//    }
//
//    private void backtrack(int[] nums, LinkedList<Integer> path) {
//        if (path.size() == nums.length) {
//            res.add(new LinkedList<>(path));
//            return;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (path.contains(nums[i])) continue;
//            path.add(nums[i]);
//            backtrack(nums, path);
//            path.removeLast();
//        }
//    }

// =============================================================================

    /**
     * 用int[] visited记录访问过的坐标
     */
//    public List<List<Integer>> permute(int[] nums) {
//
//        List<List<Integer>> res = new ArrayList<>();
//        int[] visited = new int[nums.length];
//        backtrack(res, nums, new ArrayList<Integer>(), visited);
//        return res;
//
//    }
//
//    private void backtrack(List<List<Integer>> res, int[] nums, ArrayList<Integer> tmp, int[] visited) {
//        if (tmp.size() == nums.length) {
//            res.add(new ArrayList<>(tmp));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (visited[i] == 1) continue;
//            visited[i] = 1;
//            tmp.add(nums[i]);
//            backtrack(res, nums, tmp, visited);
//            visited[i] = 0;
//            tmp.remove(tmp.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        System.out.println(
                new Permutations()
                        .permute(new int[]{1, 2, 3})
        );
    }
}
