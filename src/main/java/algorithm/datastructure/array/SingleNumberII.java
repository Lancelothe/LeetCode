package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [137] 只出现一次的数字 II
 * @difficulty Medium
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
 */
public class SingleNumberII {

    public int singleNumbers(int[] nums) {
        int ans = 0;
        //int 32位
        for (int i = 0; i < 32; i++) {
            int count = 0;
            for (int n : nums) {
                if ((n & (1 << i)) != 0) count++;
            }
            if (count % 3 != 0) ans += 1 << i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(10 & (-10));
    }
}
