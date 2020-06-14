package algorithm.slidewindow;

/**
 * @author lancelot
 * @date 2020/6/14
 * @description leetcode [992] K 个不同整数的子数组
 * @difficulty Hard
 * 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * 返回 A 中好子数组的数目。
 *
 * 示例 1：
 * 输入：A = [1,2,1,2,3], K = 2
 * 输出：7
 * 解释：恰好由 2 个不同整数组成的子数组：[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 * 链接：https://leetcode-cn.com/problems/subarrays-with-k-different-integers
 */
public class SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new SubarraysWithKDifferentIntegers()
                .subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}
