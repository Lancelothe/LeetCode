package algorithm.bit;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [231] 2的幂
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & x - 1) == 0;
    }

}
