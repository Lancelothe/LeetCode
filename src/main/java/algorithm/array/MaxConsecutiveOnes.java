package algorithm.array;

/**
 * @author lancelot
 * @date 2020/2/6
 * @description leetcode [485]
 */
public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int n : nums) {
            cur = n==0? 0 : cur+1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
