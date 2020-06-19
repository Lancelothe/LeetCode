package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/6/17
 * @description leetcode [42] 接雨水
 * @difficulty Hard
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int leftMax = -1, rightMax = -1;
        int left = 0, right = height.length - 1;
        int ans = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new TrappingRainWater()
                .trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
