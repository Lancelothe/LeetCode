package algorithm.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/19
 * @description leetcode [77] 组合
 * @difficulty Medium
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class Combinations {

    /**
     * 思路：
     * 典型的回溯问题，递归的终止条件是path.size() == k这个要搞清楚就可以了。
     */
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0) return res;

        backtrack(n, k, 1, new LinkedList<>());
        return res;
    }

    public void backtrack(int n, int k, int start, LinkedList<Integer> path) {
        if (path.size() == k) {
            res.add(new LinkedList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {
            path.add(i);
            backtrack(n, k, i + 1, path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Combinations()
                        .combine(4, 2)
        );
    }
}
