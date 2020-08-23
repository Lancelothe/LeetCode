package algorithm.dp;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [70] 爬楼梯
 * @difficulty Easy
 * @tag 动态规划
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 *
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 */
public class ClimbingStairs {
    /**
     * 思路：
     * 状态方程： f(n) = f(n-1) + f(n-2)
     */
    public static int climbStairs(int n) {
        if (n <= 2) return n;

        int oneStep = 2;
        int twoStep = 1;
        int allWay = 0;

        for (int i = 2; i < n; i++) {
            allWay = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = allWay;
        }

        return allWay;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
