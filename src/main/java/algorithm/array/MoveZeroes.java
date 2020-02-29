package algorithm.array;

/**
 * @author lancelot
 * @date 2020/2/6
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int dst = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[dst++] = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i >= dst) {
                nums[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 2, 3, 0};
        moveZeroes(nums);
    }
}
