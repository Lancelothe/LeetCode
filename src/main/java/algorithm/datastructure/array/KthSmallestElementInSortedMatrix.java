package algorithm.datastructure.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author lancelot
 * @date 2020/7/2
 * @description leetcode [378] 有序矩阵中第K小的元素
 * @difficulty Medium
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 *  
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 */
public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();
            if (now[2] != n - 1) {
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }


    public static void main(String[] args) {
        System.out.println(new KthSmallestElementInSortedMatrix().kthSmallest(new int[][]{{1,2,3}, {4,5,6}}, 3));
    }
}
