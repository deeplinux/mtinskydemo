package com.mtinsky.algorithm.list;

import java.util.Random;

/**
 * 给定两个单向链表，求他们的公共节点，如果没有则返回空
 * 代码格式优化：比较大小是，做替换
 */
public class CommonNodeList {

    public static void main(String[] args) {
        Node cNode = new Node(-1);
        for(int i=0;i<6;i++) {
            Node tNode = new Node(new Random().nextInt(9));
            tNode.next = cNode.next;
            cNode.next = tNode;
        }
        print(cNode);
        Node pHead1 = new Node(-1);
        for(int i=0;i<6;i++) {
            Node tNode = new Node(new Random().nextInt(9));
            if(i==0) {
                tNode.next = cNode.next;
            } else {
                tNode.next = pHead1.next;
            }
            pHead1.next = tNode;
        }
        Node pHead2 = new Node(-1);
        for(int i=0;i<9;i++) {
            Node tNode = new Node(new Random().nextInt(9));
            if(i==0) {
                tNode.next = cNode.next;
            } else {
                tNode.next = pHead2.next;
            }
            pHead2.next = tNode;
        }
        print(pHead1);
        print(pHead2);
        System.out.println(getCommonNode(pHead1,pHead2).num);


    }


    private static Node getCommonNode(Node pHead1,Node pHead2) {
        Node cur1 = pHead1.next;
        int pLength1 = 0;
        Node cur2 = pHead2.next;
        int pLength2 = 0;
        while (cur1!=null) {
            pLength1++;
            cur1 = cur1.next;
        }
        while (cur2!=null) {
            pLength2++;
            cur2 = cur2.next;
        }
        int interval = 0;

        cur1 = pHead1.next;
        cur2 = pHead2.next;
        if(pLength1>pLength2) {
            interval = pLength1 - pLength2;
            while (interval>=0) {
                interval--;
                cur1 = cur1.next;
            }
            while (cur1!=null) {
                if(cur1 == cur2) {
                    return cur1;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return null;
        } else {
            interval = pLength2 - pLength1;
            while (interval>0) {
                interval--;
                cur2 = cur2.next;
            }
            while (cur2!=null) {
                if(cur1 == cur2) {
                    return cur1;
                }
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return null;
        }
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
