package algorithm.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author lancelot
 * @date 2020/3/15
 * @description leetcode [98] 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) return true;

        if (lower != null && root.val <= lower) return false;
        if (upper != null && root.val >= upper) return false;

        if (!isValidBST(root.left, lower, root.val)) return false;
        if (!isValidBST(root.right, root.val, upper)) return false;

        return true;
    }

    private static List<Integer> q = new LinkedList();

    public static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        q.add(root.val);
        inOrder(root.right);
    }

    // 太慢了，用了153ms
    public static boolean isValidBST2(TreeNode root) {
        inOrder(root);
        for (int i = 0; i < q.size() - 1; i++) {
            if (q.get(i) > q.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

//        node2.left = node1;
//        node2.right = node3;

        node1.left = node2;
        node1.right = node3;

        System.out.println(isValidBST2(node1));

    }

}
