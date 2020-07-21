package algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/7/7
 * @description leetcode [144] 二叉树的前序遍历
 * @difficulty Medium
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 * 示例:
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-preorder-traversal
 */
public class BinaryTreePreOrderTraversal {


    /**
     * 递归法
     * @param root
     * @return
     */
    public List<Integer> preOrderTraversalRecursion(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode node, List<Integer> res) {
        if (null == node) return;

        res.add(node.val);
        preOrder(node.left, res);
        preOrder(node.right, res);
    }

    public static void main(String[] args) {
        /**
         *        1
         *       / \
         *      2   5
         *     / \   \
         *    3   4   6
         */
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t5;
        t2.left = t3;
        t2.right = t4;
        t5.right = t6;

        System.out.println(new BinaryTreePreOrderTraversal().preOrderTraversalRecursion(t1));
    }
}
