package com.mtinsky.algorithm.list;

import java.util.Random;

/**
 * 链表部分翻转 从m到n进行翻转
 */
public class ReverseList {
    public static void main(String[] args) {
        Node pHead = new Node(-1);
        for(int i=0;i<10;i++) {
            Node tNode = new Node(new Random().nextInt(9));
            tNode.next = pHead.next;
            pHead.next = tNode;
        }
        print(pHead);
        int from = 3;
        int to = 7;
        int i = 0;
        Node curHeadNode = pHead;
        while (i<from-1) {
            curHeadNode = curHeadNode.next;
            i++;
        }
        Node curNode = curHeadNode.next;
        Node tNode;
        for(;i<to-1;i++) {
            tNode = curNode.next;
            curNode.next = tNode.next;
            tNode.next = curHeadNode.next;
            curHeadNode.next = tNode;
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
