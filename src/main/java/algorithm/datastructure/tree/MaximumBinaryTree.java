package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/9/3
 * @description leetcode [654] 最大二叉树
 * @difficulty Medium
 * 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 * 二叉树的根是数组中的最大元素。
 * 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 * 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 * 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 *
 * 示例 ：
 * 输入：[3,2,1,6,0,5]
 * 输出：返回下面这棵树的根节点：
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 *
 * 链接：https://leetcode-cn.com/problems/maximum-binary-tree
 */
public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int max = findMax(nums, start, end);
        TreeNode root = new TreeNode(nums[max]);
        root.left = buildTree(nums, start, max - 1);
        root.right = buildTree(nums, max + 1, end);

        return root;
    }

    private int findMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE, index = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
