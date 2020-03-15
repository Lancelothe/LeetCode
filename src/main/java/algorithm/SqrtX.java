package algorithm;

/**
 * @author lancelot
 * @date 2020/3/14
 * @description leetcode [69]
 */
public class SqrtX {

    public static int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long left = 0;
        long right = x / 2;

        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return (int) left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(4));
    }
}
