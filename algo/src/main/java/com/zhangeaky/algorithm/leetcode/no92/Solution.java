package com.zhangeaky.algorithm.leetcode.no92;

import com.zhangeaky.algorithm.leetcode.ListNode;

import java.util.List;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 */
public class Solution {

    public ListNode reverseBetweenV1(ListNode head, int left, int right) {

        if (head == null) {
            return null;
        }

        // 哨兵节点
        ListNode dummy = new ListNode(-1, head);

        ListNode pre = dummy;

        for (int i=0; i<left-1; i++) {
            pre = pre.next;
        }

        ListNode leftNode = pre.next;

        ListNode rightNode = pre;

        for (int i=0; i<right-left+1; i++) {
            rightNode = rightNode.next;
        }

        ListNode post = rightNode.next;

        rightNode.next = null;
        pre.next =  null;

        reverse(leftNode);
        pre.next = rightNode;
        leftNode.next = post;

        return dummy.next;
    }

    public void reverse(ListNode head) {

        if (head == null) {
            return;
        }

        ListNode curr = head;
        ListNode pre = null;
        ListNode post = null;

        while (curr!=null) {
            post = curr.next;
            curr.next = pre;

            pre = curr;
            curr = post;
        }

    }
    /**
     * 官方标准解法
     * @param head
     * @param left
     * @param right
     * @return
     */

//    给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。
//    请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        // 第 1 步：从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        // 建议写在 for 循环里，语义清晰
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        // 第 2 步：从 pre 再走 right - left + 1 步，来到 right 节点
        ListNode rightNode = pre;
        for (int i = 0; i < right - left + 1; i++) {
            rightNode = rightNode.next;
        }

        // 第 3 步：切断出一个子链表（截取链表）
        ListNode leftNode = pre.next;
        ListNode post = rightNode.next;

        // 注意：切断链接
        pre.next = null;
        rightNode.next = null;

        // 第 4 步：同第 206 题，反转链表的子区间
        reverseLinkedList(leftNode);

        // 第 5 步：接回到原来的链表中
        pre.next = rightNode;
        leftNode.next = post;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {
        // 也可以使用递归反转一个链表
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i=2; i<10;i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        head.iterateAndPrint();
        System.out.println();
        solution.reverseBetweenV1(head, 2,8).iterateAndPrint();
    }

}
