package algorithm.array;

/**
 * @author lancelot
 * @date 2020/2/6
 * @description leetcode [283] 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
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
