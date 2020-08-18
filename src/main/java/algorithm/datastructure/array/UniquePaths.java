package algorithm.datastructure.array;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/7/28
 * @description leetcode [62] 不同路径
 * @difficulty Medium
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 问总共有多少条不同的路径？
 *
 * 示例 1:
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 *
 * 示例 2:
 * 输入: m = 7, n = 3
 * 输出: 28
 *
 * 链接：https://leetcode-cn.com/problems/unique-paths
 */
public class UniquePaths {

    /**
     * 排列组合公式解法：
     * 要走到右下角一定是向右走m-1步，向下走n-1步。也就是说总共走m-1+n-1 (m+n-2) 步，其中有m-1步是向右的。那么这就是一个组合的问题。
     * 从m+n-2步中选择m-1步向右，总共有C(m+n-2,m-1)种排列方式。C(n,m) = n!/(m!*(n-m)!)
     */
    public int uniquePaths(int m, int n) {
        // 只跟第几行第几列有关，从m+n-2步中抽出m-1步
        long ans = 1;
        for (int i = 0; i < Math.min(m - 1, n - 1); i++) {
            ans *= m + n - 2 - i;
            ans /= i + 1;
        }
        return (int) ans;
    }

    public int uniquePathsMath(int m, int n) {
        int N = n + m - 2;
        int k = m - 1;
        long res = 1;
        for (int i = 1; i <= k; i++)
            res = res * (N - k + i) / i;
        return (int) res;
    }

    /**
     * 动态规划解法：
     * 上边界和左边界都是1
     * [1, 1, 1]
     * [1, 2, 3]
     * [1, 3, 6]
     * m = 3 , n = 3
     * 有点类似杨辉三角
     */
    public int uniquePathsDp(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePathsMath(3, 4));
    }
}
