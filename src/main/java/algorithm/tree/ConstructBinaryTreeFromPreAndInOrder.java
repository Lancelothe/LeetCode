package algorithm.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lancelot
 * @date 2020/3/22
 * @description leetcode [105] 从前序与中序遍历序列构造二叉树
 */
public class ConstructBinaryTreeFromPreAndInOrder {

    public static Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode buildTree(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;

        int rootVal = preOrder[preStart];
        int rootIndex = indexMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        if (preStart == preEnd) {
            return root;
        } else {
            int leftNodes = rootIndex - inStart, rightNodes = inEnd - rootIndex;
            root.left = buildTree(preOrder, preStart + 1, preStart + leftNodes, inOrder, inStart, rootIndex - 1);
            root.right = buildTree(preOrder, preEnd - rightNodes + 1, preEnd, inOrder, rootIndex + 1, inEnd);

            return root;
        }
    }


    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};


        System.out.println(buildTree(pre, in));

    }
}
