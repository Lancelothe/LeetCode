package algorithm.datastructure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/8/20
 * @description leetcode [56] 合并区间
 * @difficulty Medium
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 *
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        int len = intervals.length;
        for (int i = 1; i < len; i++) {
            int[] preIntervals = res.get(res.size() - 1);
            int[] curIntervals = intervals[i];
            if (curIntervals[0] > preIntervals[1]) {
                res.add(curIntervals);
            } else {
                preIntervals[1] = Math.max(curIntervals[0], preIntervals[1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }


}
