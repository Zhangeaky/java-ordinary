package com.zhangeaky.algorithm.leetcode.no94;

import com.zhangeaky.algorithm.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class wrongCase1 {

    public static TreeNode buildTree() {

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));

        return root;
    }

    /**
     * 94. 二叉树的前序遍历
     * https://leetcode.cn/problems/binary-tree-inorder-traversal/
     */
    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (Objects.isNull(root)) {
            return result;
        }

        putValue(root, result);

        return result;
    }

    public void putValue(TreeNode node, List<Integer> result) {

        if (Objects.nonNull(node.left)) {
            putValue(node.left, result);
        }

        result.add(node.val);

        if (Objects.nonNull(node.right)) {
            putValue(node.right, result);
        }

    }

    public static void main(String[] args) {

        wrongCase1 wrongCase1 = new wrongCase1();
        List<Integer> integers = wrongCase1.inorderTraversal(buildTree());
        System.out.println(integers);

    }

}
