package com.zhangeaky.algorithm.leetcode.no144;

import com.zhangeaky.algorithm.leetcode.TreeNode;
import com.zhangeaky.algorithm.leetcode.no94.wrongCase1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 使用递归解法的 二叉树前序遍历
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 */
public class No144 {


    public List<Integer> preorderTraversal(TreeNode root) {

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

        list.add(node.val);
        putVal(node.left, list);
        putVal(node.right, list);

    }

    public static void main(String[] args) {

        No144 instance = new No144();
        List<Integer> integers = instance.preorderTraversal(wrongCase1.buildTree());
        System.out.println(integers);

    }






}
