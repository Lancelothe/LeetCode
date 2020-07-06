package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/7/5
 * Morris Traversal
 * 非递归且不用额外空间（不用栈），遍历二叉树
 * 1. O(1)空间复杂度，即只能使用常数空间；
 * 2. 二叉树的形状不能被破坏（中间过程允许改变其形状）。
 * https://www.cnblogs.com/AnnieKim/archive/2013/06/15/MorrisTraversal.html
 */
public class ThreadedBinaryTree {

    void inorderMorrisTraversal(TreeNode root) {
        TreeNode cur = root, prev = null;
        while (cur != null)
        {
            if (cur.left == null)          // 1.
            {
                System.out.printf("%d ", cur.val);
                cur = cur.right;
            }
            else
            {
                // find predecessor
                prev = cur.left;
                while (prev.right != null && prev.right != cur)
                    prev = prev.right;

                if (prev.right == null)   // 2.a)
                {
                    prev.right = cur;
                    cur = cur.left;
                }
                else                       // 2.b)
                {
                    prev.right = null;
                    System.out.printf("%d ", cur.val);
                    cur = cur.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadedBinaryTree t = new ThreadedBinaryTree();
        TreeNode root = t.createTree();
        t.inorderMorrisTraversal(root);
    }

    /**
     *    创建测试的二叉树
     *           1
     *         /   \
     *        2     3
     *       / \     \
     *      4   5     6
     *         / \   / \
     *        7   8 9   10
     *
     * @return
     */
    private TreeNode createTree() {
        TreeNode root = new TreeNode(1);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        root.left = node2;
        root.right = node3;

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(6);
        node3.right = node6;

        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node5.left = node7;
        node5.right = node8;

        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        node6.left = node9;
        node6.right = node10;

        return root;
    }
}
