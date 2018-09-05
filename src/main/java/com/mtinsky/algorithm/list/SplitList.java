package com.mtinsky.algorithm.list;

import java.util.Random;

/**
 * 划分链表，使得小于X的在前，大于等于x的在后，且保持顺序
 * 注意最后右链表的next需要置为null，否则可能造成循环
 */
public class SplitList {
    public static void main(String[] args) {
        Node pHead = new Node(-1);
        for(int i=0;i<10;i++) {
            Node tNode = new Node(new Random().nextInt(9));
            tNode.next = pHead.next;
            pHead.next = tNode;
        }
        print(pHead);

        int x = 4;

        Node rightHead = new Node(-1);
        Node leftHead = new Node(-1);
        Node tNode = pHead.next;
        Node left = leftHead;
        Node right = rightHead;

        while (tNode!=null) {
            if(tNode.num<x) {
                left.next = tNode;
                left = tNode;
            } else {
                right.next = tNode;
                right = tNode;
            }
            tNode = tNode.next;
        }

        right.next = null;
        left.next = rightHead.next;
        pHead.next = leftHead.next;

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
