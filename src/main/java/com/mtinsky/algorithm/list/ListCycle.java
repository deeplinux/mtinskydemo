package com.mtinsky.algorithm.list;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/description/
 * 采用指向头的做法，另外一种做法是快慢指针
 */
public class ListCycle {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
    public boolean hasCycle(ListNode head) {
        ListNode cur = head;
        ListNode tCur = null;
        while (cur!=null) {
            if(cur.next==head) {
                return true;
            }
            tCur = cur;
            cur = cur.next;
            tCur.next = head;
        }
        return false;
    }

    public static void main(String[] args) {
        ListCycle listCycle = new ListCycle();
        ListNode listNode = listCycle.createNode();
        System.out.println(listCycle.hasCycle(listNode));
    }

    private ListNode createNode() {
        ListNode listNode = new ListNode(1);
        listNode.next = listNode;
        return listNode;
    }
}
