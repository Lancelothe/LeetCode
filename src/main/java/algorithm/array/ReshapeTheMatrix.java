package algorithm.array;

/**
 * @author lancelot
 * @date 2020/2/6
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
