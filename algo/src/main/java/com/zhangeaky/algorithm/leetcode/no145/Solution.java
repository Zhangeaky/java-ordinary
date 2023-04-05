package com.zhangeaky.algorithm.leetcode.no145;

import com.zhangeaky.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 二叉树的后序遍历
 */
class Solution {

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (Objects.isNull(root)) {
            return result;
        }

        putVal(root, result);

        return result;
    }

    private void putVal(TreeNode node, List<Integer> list) {

        if (Objects.isNull(node)) {
            return;
        }

        putVal(node.left, list);
        putVal(node.right, list);
        list.add(node.val);

    }

    public static TreeNode buildTree() {

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));

        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<Integer> integers = solution.postorderTraversal(buildTree());
        System.out.println(integers);
    }
}