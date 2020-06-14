package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/4/18
 * @description leetcode [35] 搜索插入位置
 * @difficulty Easy
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 *  链接：https://leetcode-cn.com/problems/search-insert-position
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int mid;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                right--;
            } else if (target > nums[mid]) {
                left++;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
