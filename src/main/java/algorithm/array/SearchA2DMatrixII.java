package algorithm.array;

/**
 * @author lancelot
 * @date 2020/2/6
 * @description leetcode [240] 搜索二维矩阵 II
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
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


}
