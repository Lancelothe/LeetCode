package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/7/28
 * @description leetcode [63] 不同路径 II
 * @difficulty Medium
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 * 链接：https://leetcode-cn.com/problems/unique-paths-ii
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int n = obstacleGrid.length; // 行
        int m = obstacleGrid[0].length; // 列

        int[][] nums = new int[n][m];
        for (int i = 0; i < n && obstacleGrid[i][0] == 0; i++) {
            nums[i][0] = 1;
        }
        for (int j = 0; j < m && obstacleGrid[0][j] == 0; j++) {
            nums[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (obstacleGrid[i][j] == 0) {
                    nums[i][j] = nums[i - 1][j] + nums[i][j - 1];
                }
            }
        }
        return nums[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] n = new int[][]{{0, 1}};
//        int[][] n = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        System.out.println(new UniquePathsII().uniquePathsWithObstacles(n));
    }
}
