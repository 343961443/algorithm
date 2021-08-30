package com.zs.algorithm.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * Input: preorder = [3,9,20,15,7],
 * inorder =         [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * [ 根节点, [左子树的前序遍历结果], [右子树的前序遍历结果] ]
 * [ [左子树的中序遍历结果], 根节点, [右子树的中序遍历结果] ]
 *
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;

        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeInternal(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode buildTreeInternal(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int root = preLeft;
        TreeNode node = new TreeNode(preorder[preLeft]);
        int rootIndex = indexMap.get(preorder[root]);
        int distance = rootIndex - inLeft;
        node.left = buildTreeInternal(preorder, inorder, preLeft + 1, preLeft + distance, inLeft, rootIndex - 1);
        node.right = buildTreeInternal(preorder, inorder, preLeft + distance + 1, preRight, rootIndex + 1, inRight);
        return node;
    }
}
