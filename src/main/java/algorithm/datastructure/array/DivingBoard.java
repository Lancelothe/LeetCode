package algorithm.datastructure.array;

import java.util.Arrays;

/**
 * @author lancelot
 * @date 2020/7/8
 * @description leetcode [面试题 16.11] 跳水板
 * @difficulty Easy
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * 返回的长度需要从小到大排列。
 *
 * 示例：
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 *
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 */
public class DivingBoard {

    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[]{};
        if (shorter == longer) return new int[]{k};
        int[] res = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            res[i] = (k - i) * shorter + i * longer;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DivingBoard().divingBoard(1, 1, 100)));
    }
}
