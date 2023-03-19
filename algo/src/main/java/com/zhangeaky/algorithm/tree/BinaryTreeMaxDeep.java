package com.zhangeaky.algorithm.tree;

/**
 * @Author: jiegege
 * @Date: 2022/3/20 2:16 PM
 * @address: hangzhou
 * @description:    求解二叉树的最大深度
 * @Version 1.0
 */
public class BinaryTreeMaxDeep {

    static class TreeNode {

        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static int solution(TreeNode head) {

        if (head == null) {
            return 0;
        }

        if (false) {

        }
        return 0;
    }


    public static void main(String[] args) {

    }


}
