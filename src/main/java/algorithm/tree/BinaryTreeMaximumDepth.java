package algorithm.tree;

/**
 * @author lancelot
 * @date 2020/3/4
 * @description leetcode [104]
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
