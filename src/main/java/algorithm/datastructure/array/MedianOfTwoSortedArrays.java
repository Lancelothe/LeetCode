package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2019/5/8
 * @description leetcode [4] 寻找两个有序数组的中位数
 * @difficulty Hard ★★★
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 *  示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianLength = (nums1.length + nums2.length) / 2 + 1;
        int[] ans = new int[medianLength];
        double res = 0;
        int left = 0, right = 0;
        for (int i = 0; i < medianLength && left < nums1.length && right < nums2.length; i++) {
            if (left >= nums1.length) {

                ans[i] = nums2[right++];

            } else {

            }

            if (nums1[left] < nums2[right]) {
                ans[i] = nums1[left++];
            } else {
                ans[i] = nums2[right++];
            }
        }


        if ((nums1.length + nums2.length) % 2 == 0) {
            res = (ans[ans.length - 2] + ans[ans.length - 1]) / 2.0;
        } else {
            res = ans[ans.length - 1];
        }

        return res;
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        //选择长度较小的那个数组进行查找
        if (nums1.length > nums2.length) return findMedianSortedArrays2(nums2, nums1);
        if (nums1.length == 0) {
            if (nums2.length % 2 != 0) return nums2[length / 2];
            else return (nums2[length / 2 - 1] + nums2[length / 2]) / 2.0;
        }
        ////初始化二分查找的边界
        int L_edge = 0, R_edge = nums1.length;
        int cur1 = 0, cur2 = 0;
        double result = 0;
        while (L_edge <= R_edge) {
            cur1 = L_edge + (R_edge - L_edge) / 2;
            cur2 = (length + 1) / 2 - cur1;
            //计算出L1，R1，L2，R2
            double L1 = cur1 == 0 ? Integer.MIN_VALUE : nums1[cur1 - 1];
            double R1 = cur1 == nums1.length ? Integer.MAX_VALUE : nums1[cur1];
            double L2 = cur2 == 0 ? Integer.MIN_VALUE : nums2[cur2 - 1];
            double R2 = cur2 == nums2.length ? Integer.MAX_VALUE : nums2[cur2];
            //二分查找，重新划定边界
            if (L1 > R2) R_edge = cur1 - 1;
            else if (L2 > R1) L_edge = cur1 + 1;
            else {
                //注意长度为奇数偶数的问题，奇数取中间的那个值，偶数则取两边的和的一半
                if (length % 2 != 0) result = Math.max(L1, L2);
                else result = (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays()
                .findMedianSortedArrays2(new int[]{2, 3, 8, 10, 11, 21}, new int[]{1, 4, 5, 6, 7, 9, 13, 14}));
    }

}
