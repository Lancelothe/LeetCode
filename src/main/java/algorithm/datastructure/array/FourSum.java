package algorithm.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/4/12
 * @description leetcode [18] 四数之和
 * @difficulty Medium
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (len < 4) return ans;
        Arrays.sort(nums);

        int minValue = nums[0] + nums[1] + nums[2] + nums[3];
        int maxValue = nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4];
        if (maxValue < target || minValue > target) {
            return ans;
        }
        int fourNumSum = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                // 放开下面这段代码，性能会达到飞速提升，
                // 执行用时 :3 ms, 在所有 Java 提交中击败了99.97%的用户
                // 之前是 执行用时 :7 ms, 在所有 Java 提交中击败了69.86%的用户
//                minValue = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
//                maxValue = nums[i] + nums[j] + nums[len - 2] + nums[len - 1];
//                if (minValue > target)
//                    continue;
//                if (maxValue < target)
//                    continue;


                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    fourNumSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (fourNumSum > target) {
                        right--;
                    } else if (fourNumSum < target) {
                        left++;
                    } else {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
