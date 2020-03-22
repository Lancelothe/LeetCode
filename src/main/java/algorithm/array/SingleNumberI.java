package algorithm.array;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [136] 只出现一次的数字
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumberI {

    public static int singleNumbers(int[] nums) {
        int xor = 0;
        for (int n : nums) {
            xor ^= n;
        }

        return xor;
    }

    public static void main(String[] args) {
        System.out.println(10 & (-10));

        int[] nums = new int[]{2,2,1,3,3};
        System.out.println(singleNumbers(nums));
    }
}
