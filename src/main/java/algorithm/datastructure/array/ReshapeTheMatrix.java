package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/2/6
 * @description leetcode [566] 重塑矩阵
 * @difficulty Easy
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 */
public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums == null || nums[0].length * nums.length != r * c) {
            return nums;
        }

        int[] tmp = new int[r*c+1];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                tmp[k++] = nums[i][j];
            }
        }
        k = 0;
        int[][] newNums = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newNums[i][j] = tmp[k++];
            }
        }
        return newNums;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,2},{4,5},{3,4}};
        System.out.println(matrixReshape(nums, 2, 3));
    }
}
