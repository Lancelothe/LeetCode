package algorithm.math;

/**
 * @author lancelot
 * @date 2020/3/23
 * @description leetcode [263] 丑数 I
 * 判断是否是丑数。
 *
 * 丑数就是只包含质因数 2, 3, 5 的正整数。
 */
public class UglyNumberI {
    public boolean nthUglyNumber(int num) {
        if (num <= 0) return false;
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
                continue;
            }
            if (num % 3 == 0) {
                num /= 3;
                continue;
            }
            if (num % 5 == 0) {
                num /= 5;
                continue;
            }
            return false;
        }
        return true;
    }


}
