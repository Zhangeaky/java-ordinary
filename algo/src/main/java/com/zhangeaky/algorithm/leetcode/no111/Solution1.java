package com.zhangeaky.algorithm.leetcode.no111;

import com.zhangeaky.algorithm.leetcode.TreeNode;
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

        return process(root, minDepth);

    }

    private Integer process(TreeNode currentNode, Integer currentDepth) {

        if (null == currentNode) {
            return currentDepth;
        }
        currentDepth++;
        int leftValue = currentDepth;
        int rightValue = currentDepth;


        if (null != currentNode.left) {
            leftValue = process(currentNode.left, currentDepth);
        }

        if (null != currentNode.right) {
            rightValue = process(currentNode.right, currentDepth);
        }

        return Math.min(rightValue, leftValue);

    }

    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        int i = solution1.minDepth(build());
        System.out.println(i);

    }


}
