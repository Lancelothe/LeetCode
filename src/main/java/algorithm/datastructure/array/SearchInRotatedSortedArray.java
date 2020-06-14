package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/4/15
 * @description leetcode [33] 搜索旋转排序数组
 * @difficulty Medium
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 你可以假设数组中不存在重复的元素。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 示例 1:
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 *
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        if (nums == null) return -1;

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] < nums[right]) {
                // 右侧有序
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左侧有序
                if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

    /**
     * 相关题，不同的是可以有重复元素
     * 2,1,2测试用例过不了，有毒，先放下。
     */
    public int search2(int[] nums, int target) {
        if (nums == null) return -1;

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (nums[mid] > nums[left]) {
                // 左侧有序
                if (target <= nums[mid] && nums[left] <= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < nums[left]) {
                // 左侧乱序
                if (target <= nums[mid] || nums[left] <= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target != nums[left]) {
                    left++;
                } else {
                    left = mid;
                }
            }
        }

        return -1;
    }

    public int search3(int[] nums, int target) {
        int len = nums.length;

        // 题目给的数据保证数组非空，因此无需再判断

        int left = 0;
        int right = len - 1;
        while (left < right) {

            int mid = (left + right) >>> 1;

            // 调试代码
            // System.out.println("left = " + left + " right = " + right + " mid = " + mid +  " nums[mid] = " + nums[mid]);

            if (nums[mid] < nums[right]) {
                // 此时 [mid, right] 这个区间一定有序

                // 注意：为了让边界收缩行为一直，这里 nums[mid] < target 不取等号，这样才能凑出 left = mid + 1 和后面的分支统一
                if (nums[mid] < target && target <= nums[right]) {
                    // 下一轮搜索区间是 [mid + 1, right]，设置 left = mid
                    left = mid + 1;
                } else {
                    // if 的反面，下一轮搜索区间是 [left, mid]
                    right = mid;
                }

            } else if (nums[mid] > nums[right]) {
                // 此时 [left, mid] 一定有序

                if (nums[left] <= target && target <= nums[mid]) {
                    // 下一轮搜索区间是 [left, mid]
                    right = mid;
                } else {
                    // if 的反面，下一轮搜索区间是 [mid + 1, right]
                    left = mid + 1;
                }
            } else {
                // 此时 nums[mid] == nums[right]

                if (nums[mid] == target) {
                    // {2, 1, 2, 2, 2}; target = 2
                    // mid 的右边一定不是解，下一轮搜索的区间是 [left, mid]
                    right = mid;
                } else {
                    // target = 1
                    // {2, 1, 2, 2, 2};
                    // {2, 2, 2, 1, 2};

                    // 根据上面的例子，只能把 right 这个位置排除掉，下一轮搜索的区间是 [left, right - 1]
                    right--;
                }
            }
        }

        // 有可能区间内不存在目标元素，因此还需做一次判断
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search2(new int[]{1, 1, 1, 1, 1, 2, 1, 1, 1}, 2));
        System.out.println(new SearchInRotatedSortedArray().search2(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new SearchInRotatedSortedArray().search3(new int[]{5, 5, 5, 1, 2, 3, 4, 5}, 5));
    }
}
