package algorithm.bit;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [231] 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class PowerOfTwo {
    /**
     * 思路：
     * 如果n是2的N次幂，则n&n-1为0
     * 注意这里可能溢出，所以用long型
     */
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & x - 1) == 0;
    }

}
