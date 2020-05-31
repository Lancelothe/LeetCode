package algorithm.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/5/31
 * @description leetcode [119] 杨辉三角II
 * @difficulty Easy
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 *
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 *
 * 输入: 3
 * 输出: [1,3,3,1]
 * 进阶：
 *
 * 你可以优化你的算法到 O(k) 空间复杂度吗？
 *
 * 链接：https://leetcode-cn.com/problems/pascals-triangle-ii/
 */
public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new LinkedList<>();
        for (int i = 0; i <= rowIndex; i++) {
            tmp.add(0, 1);
            for (int j = 1; j < tmp.size() - 1; j++)
                tmp.set(j, tmp.get(j) + tmp.get(j + 1));
        }
        return tmp;
    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     * 第三行依次是：C30，C31，C32， C33
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new PascalTriangleII()
                        .getRow2(5));
    }
}
