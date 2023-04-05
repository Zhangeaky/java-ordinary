package com.zhangeaky.algorithm.tree;

import com.zhangeaky.algorithm.leetcode.TreeNode;

/**
 * @Author: jiegege
 * @Date: 2022/3/20 2:20 PM
 * @address: hangzhou
 * @description:
 * @Version 1.0
 */
public class CreateATree {

    public static TreeNode buildTree() {

        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));

        return root;
    }



}
