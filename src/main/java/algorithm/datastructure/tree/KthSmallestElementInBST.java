package algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/6/19
 * @description leetcode [230] 二叉搜索树中第K小的元素
 * @difficulty Medium
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 *
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 */
public class KthSmallestElementInBST {

    /**
     * 递归解法：中序遍历
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans.get(k - 1);
    }

    private static void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) return;
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }


    /**
     * 迭代解法
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) return  -1;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }

            root = stack.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }

        return root.val;
    }


    public static void main(String[] args) {
        /**
         *     4
         *    / \
         *   2   5
         *  / \
         * 1   3
         */
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(1);
        TreeNode t5 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;


        System.out.println(new KthSmallestElementInBST().kthSmallest(t1, 1));
        System.out.println(new KthSmallestElementInBST().kthSmallest2(t1, 1));
    }
}
