package algorithm;

/**
 * @author lancelot
 * @date 2020/2/1
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
