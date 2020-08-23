package algorithm.binarysearch;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/2/6
 * @description leetcode [240] 搜索二维矩阵 II & 面试题 10.09. 排序矩阵查找
 * @difficulty Medium
 * @tag 二分查找
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 *
 * 示例:
 * 现有矩阵 matrix 如下：
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * 给定 target = 20，返回 false。
 *
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix-ii
 */
public class SearchA2DMatrixII {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int row = matrix.length, col = matrix[0].length;
        int m =0, n = col-1;
        while (m < row && n >= 0) {
            if (target == matrix[m][n]) {
                return true;
            } else if (target < matrix[m][n]) {
                n--;
            } else {
                m++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.toString(matrix));
        System.out.println(Arrays.toString(matrix[0]));
    }
}
