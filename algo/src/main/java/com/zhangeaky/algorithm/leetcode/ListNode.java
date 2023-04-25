package com.zhangeaky.algorithm.leetcode;

public class ListNode {
  int val;
  public ListNode next;
  ListNode() {}
  public ListNode(int val) { this.val = val; }
  public ListNode(int val, ListNode next) { this.val = val; this.next = next; }


  public void addToTail(int val) {

    ListNode newNode = new ListNode(val);
    ListNode curr = this;

    while (curr.next!=null) {
      curr = curr.next;
    }
    curr.next = newNode;

  }

  public void iterateAndPrint() {

    ListNode node = this;

    while (node!=null) {
      System.out.print(node.val + "-->");
      node = node.next;
      if (node==null) {
        System.out.print("null");
      }
    }
  }
}

