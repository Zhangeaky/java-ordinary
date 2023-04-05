package com.zhangeaky.algorithm.leetcode.no226;

import com.zhangeaky.algorithm.leetcode.TreeNode;
import com.zhangeaky.algorithm.tree.CreateATree;

import java.util.Objects;

/**
 * https://leetcode.cn/problems/invert-binary-tree/
 */
public class Solution {

    public TreeNode invertTree(TreeNode root) {

        if (Objects.isNull(root)) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode treeNode = solution.invertTree(CreateATree.buildTree());
        System.out.println(treeNode);
        //TreeNode treeNode = solution.invertTree(null);
    }

}
