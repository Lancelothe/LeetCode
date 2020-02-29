package algorithm.array;

/**
 * @author lancelot
 * @date 2020/2/6
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
