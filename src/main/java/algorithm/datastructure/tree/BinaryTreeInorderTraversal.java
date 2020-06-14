package algorithm.datastructure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/3/4
 * @description leetcode [94] 二叉树的中序遍历
 * @difficulty Medium
 * 给定一个二叉树，返回它的中序 遍历。
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 */
public class BinaryTreeInorderTraversal {
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        helper(root, result);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

        System.out.println(node1);
        System.out.println(node2);
        System.out.println(node3);

        System.out.println("\n");
        System.out.println(inorderTraversal(node2));
    }
}
