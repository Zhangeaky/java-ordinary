package com.zhangeaky.algorithm.leetcode.no111;

import com.zhangeaky.algorithm.leetcode.TreeNode;
import com.zhangeaky.algorithm.leetcode.TreeNodeUtil;
import com.zhangeaky.algorithm.leetcode.no226.Solution;

/**
 * 求二叉树的最小深度
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 */
public class Solution1 {

    public static TreeNode build() {

        TreeNode root = new TreeNode(2,
                null, new TreeNode(3, new TreeNode(4, new TreeNode(5, new TreeNode(6, null, null), null), null), null));

        return root;
    }

    public int minDepth(TreeNode root) {

        int minDepth = 0;
        if (null == root) {
            return minDepth;
        }

        return process(root, minDepth+1);

    }

    private Integer process(TreeNode currentNode, int currentDepth) {

        if (null == currentNode.left && null == currentNode.right) {
            return currentDepth;
        }

        int leftValue = currentDepth;
        int rightValue = currentDepth;
        int result = currentDepth;

        if (null != currentNode.left) {
            leftValue = process(currentNode.left, currentDepth+1);
            result = leftValue;
        }

        if (null != currentNode.right) {
            if (currentNode.left == null) {
                rightValue = process(currentNode.right, currentDepth+1);
            } else {
                rightValue = Math.min(process(currentNode.right, currentDepth+1), leftValue);
            }
            result = rightValue;
        }

        return result;

    }

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        int i = solution1.minDepth(build());
        System.out.println(i);

        TreeNode treeNode = TreeNodeUtil
                .arrayToTreeNode(new Integer[]{2, null, 3, null, 4, null, 5, null, 6});
        System.out.println(treeNode);

    }


}
