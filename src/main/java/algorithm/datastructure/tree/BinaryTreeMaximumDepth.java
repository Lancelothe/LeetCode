package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/3/4
 * @description leetcode [104] 二叉树最大深度
 * @difficulty Easy
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree
 */
public class BinaryTreeMaximumDepth {
    public static int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
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
        System.out.println(maxDepth(node2));
    }
}
