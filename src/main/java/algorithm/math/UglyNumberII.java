package algorithm.math;

/**
 * @author lancelot
 * @date 2020/3/23
 * @description leetcode [264] 丑数 II
 * 编写一个程序，找出第 n 个丑数。
 * <p>
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:  
 * <p>
 * 1 是丑数。
 * n 不超过1690。
 */
public class UglyNumberII {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];

        dp[0] = 1;
        int dp2 = 0, dp3 = 0, dp5 = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[dp2] * 2, Math.min(dp[dp3] * 3, dp[dp5] * 5));
            if (dp[i] == dp[dp2] * 2) {
                dp2++;
            }
            if (dp[i] == dp[dp3] * 3) {
                dp3++;
            }
            if (dp[i] == dp[dp5] * 5) {
                dp5++;
            }
        }
        return dp[n - 1];
    }


}
