package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/18
 * @description leetcode [114] 二叉树展开为链表
 * @difficulty Medium
 * 给定一个二叉树，原地将它展开为一个单链表。
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 */
public class FlattenBinaryTreeToLinkedList {

    /**
     * 递归解法
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) return;

        //将根节点的左子树变成链表
        flatten(root.left);
        //将根节点的右子树变成链表
        flatten(root.right);
        TreeNode temp = root.right;
        //把树的右边换成左边的链表
        root.right = root.left;
        //记得要将左边置空
        root.left = null;
        //找到树的最右边的节点
        while(root.right != null) root = root.right;
        //把右边的链表接到刚才树的最右边的节点
        root.right = temp;
    }

    /**
     * 迭代解法
     * @param root
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode temp = root.left;
                // 找左子树最右边的节点
                while (temp.right != null) temp = temp.right;
                //将原来的右子树接到左子树的最右边节点
                temp.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
            }
            //移动指针到下一个右子树节点
            root = root.right;
        }
    }

    public static void main(String[] args) {
        /**
         *      1
         *     / \
         *    2   5
         *   / \   \
         *  3   4   6
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

        System.out.println(t1);
        new FlattenBinaryTreeToLinkedList().flatten(t1);
        new FlattenBinaryTreeToLinkedList().flatten2(t1);
        System.out.println(t1);
    }

}
