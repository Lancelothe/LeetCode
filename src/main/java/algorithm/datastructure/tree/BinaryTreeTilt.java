package algorithm.datastructure.tree;

/**
 * @author lancelot
 * @date 2020/6/20
 * @description leetcode [563] 叉树的坡度
 * @difficulty Easy
 * 给定一个二叉树，计算整个树的坡度。
 * 一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。
 * 整个树的坡度就是其所有节点的坡度之和。
 * 示例：
 * 输入：
 *          1
 *        /   \
 *       2     3
 * 输出：1
 * 解释：
 * 结点 2 的坡度: 0
 * 结点 3 的坡度: 0
 * 结点 1 的坡度: |2-3| = 1
 * 树的坡度 : 0 + 0 + 1 = 1
 *
 * 链接：https://leetcode-cn.com/problems/binary-tree-tilt
 */
public class BinaryTreeTilt {

    private int sum;
    public int findTilt(TreeNode root) {
        if (root == null) return 0;

         sum = 0;

        traverse(root);
        return sum;
    }

    private int traverse(TreeNode root) {
        if (root == null) return 0;

        int left = traverse(root.left) ;
        int right = traverse(root.right) ;

        sum += Math.abs(left - right);
        return left + right + root.val;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;

        System.out.println(new BinaryTreeTilt().findTilt(t1));
    }
}
