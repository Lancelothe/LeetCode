package algorithm.array;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [260]
 * 数组中数字出现的次数（两个只出现一次的数字）
 * <p>
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class SingleNumberIII {

    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        int x = 0;
        for (int n : nums) {
            xor ^= n;
        }
        int diff = xor & (-xor);
        for (int n : nums) {
            if ((n & diff) != 0) {
                x ^= n;
            }
        }
        return new int[]{x, xor ^ x};
    }

    public static void main(String[] args) {
        System.out.println(10 & (-10));
    }
}
