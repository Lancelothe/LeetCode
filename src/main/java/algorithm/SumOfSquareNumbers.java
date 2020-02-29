package algorithm;

/**
 * @author lancelot
 * @date 2020/2/1
 */
public class SumOfSquareNumbers {
    public static boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        int end = (int) Math.sqrt(c);
        int start = 0;
        while (start <= end) {
            if (start * start + end * end > c) {
                end--;
            } else if (start * start + end * end < c) {
                start++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }
}
