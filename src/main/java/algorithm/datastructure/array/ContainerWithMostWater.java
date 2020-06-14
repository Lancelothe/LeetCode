package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/4/10
 * @description leetcode [11] 盛最多水的容器
 * @difficulty Medium
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class ContainerWithMostWater {
    /**
     * 思路：
     * 双指针解法，从外向内靠近求最大值
     */
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            res = Math.max(res, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(c.maxArea(height));
    }
}
