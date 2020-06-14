package algorithm.datastructure.array;

/**
 * @author lancelot
 * @date 2020/4/18
 * @description leetcode [27] 移除元素
 * @difficulty Easy
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 * 给定 nums = [3,2,2,3], val = 3,
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 链接：https://leetcode-cn.com/problems/remove-element
 */
public class RemoveElement {

    /**
     * 思路：
     * 二分查找的思想，但是有个问题需要注意，就是会找不到，则循环中num[mid]==target不成立，最后是在left==right时返回，所以这里就是插入点。
     */
    public int removeElement(int[] nums, int val) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[cur++] = nums[i];
            }
        }

        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
    }
}
