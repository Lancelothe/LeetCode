package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/7/27
 * @description leetcode [45] 跳跃游戏II
 * @difficulty Hard
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 *
 * 示例:
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 说明:
 * 假设你总是可以到达数组的最后一个位置。
 *
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 */
public class JumpGameII {
    public boolean canJump(int[] nums) {
        return true;
    }

    /**
     * 反向查找
     * 时间复杂度 O(n^2)
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int position = nums.length - 1; //要找的位置
        int steps = 0;
        while (position != 0) { //是否到了第 0 个位置
            for (int i = 0; i < position; i++) {
                if (nums[i] >= position - i) {
                    position = i; //更新要找的位置
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }

    /**
     * 正向查找
     * 时间复杂度 O(n)
     *
     * @param nums
     * @return
     */
    public int jump2(int[] nums) {
        int max = 0, end = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                end = max;
                step++;
            }
        }

        return step;
    }


    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump2(new int[]{2, 3, 1, 2, 4, 2, 3}));
    }

}
