package com.mtinsky.algorithm.list;

import java.util.Random;

/**
 * 已排序链表的去重,重复的元素只保留其中一个
 */
public class SortListDuplicateRemoval {
    public static void main(String[] args) {
        int[] value = new int[]{9,9,9,8,8,5,5,4,4,3,2,1};
        Node pHead = new Node(-1);
        for(int i=0;i<12;i++) {
            Node tNode = new Node(value[i]);
            tNode.next = pHead.next;
            pHead.next = tNode;
        }
        print(pHead);

        Node cur = pHead.next;
        Node pre = pHead;
        while(cur.next!=null) {
            if(cur.next.num == cur.num) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        print(pHead);


    }

    private static void print(Node pHead) {
        Node tNode = pHead.next;
        while (tNode!=null) {
            System.out.print(tNode.num);
            tNode = tNode.next;
        }
        System.out.println();
    }
}
