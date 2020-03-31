package algorithm.array;

/**
 * @author lancelot
 * @date 2020/2/1
 * @description leetcode [88] 合并两个有序数组
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergeLength = m + n - 1;
        int endM = m - 1;
        int endN = n - 1;

        while (endM >= 0 || endN >= 0) {
            if (endM < 0) {
                nums1[mergeLength--] = nums2[endN--];
            } else if (endN <0) {
                nums1[mergeLength--] = nums1[endM--];
            } else if (nums1[endM] >= nums2[endN]) {
                nums1[mergeLength--] = nums1[endM--];
            } else {
                nums1[mergeLength--] = nums2[endN--];
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }


    public static void main(String[] args) {
        int[] num1 = new int[ ]{0};
        int[] num2 = new int[ ]{2};

        merge(num1, 0, num2, 1);
    }
}