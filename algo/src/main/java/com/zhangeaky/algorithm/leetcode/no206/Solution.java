package com.zhangeaky.algorithm.leetcode.no206;

import com.alibaba.fastjson.JSON;

import java.util.List;
import java.util.Objects;

/**
 * Definition for singly-linked list.
 */
class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;

        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode post = null;
        ListNode curr = head;

        while (curr != null) {
             post = curr.next;
             curr.next = pre;
             pre = curr;
             curr = post;
        }

        return pre;
    }

    static class A {
        public int a;
    }

    public static void main(String[] args) {

        ListNode one = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        Solution ss = new Solution();
        ListNode node = ss.reverseList(one);
        String s = JSON.toJSONString(node);
        System.out.println(s);

    }

}