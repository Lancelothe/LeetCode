package algorithm.datastructure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [106] 从中序与后序遍历序列构造二叉树
 * @difficulty Medium
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 */
public class ConstructBinaryTreeFromInAndPostOrder {

    public Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length != postorder.length) {
            return null;
        }
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] postOrder, int postOrderStart, int postOrderEnd, int[] inOrder, int inOrderStart, int inOrderEnd) {
        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) return null;

        int rootVal = postOrder[postOrderEnd];
        int rootIndex = indexMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        if (postOrderStart == postOrderEnd) {
            return root;
        } else {
            int leftNodes = rootIndex - inOrderStart, rightNodes = inOrderEnd - rootIndex;
            root.left = buildTree(postOrder, postOrderStart, postOrderStart + leftNodes - 1, inOrder, inOrderStart, rootIndex - 1);
            root.right = buildTree(postOrder, postOrderEnd - rightNodes, postOrderEnd - 1, inOrder, rootIndex + 1, inOrderEnd);

            return root;
        }
    }
}
