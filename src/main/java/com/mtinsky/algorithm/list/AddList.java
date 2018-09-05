package com.mtinsky.algorithm.list;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 求两个数字相加，两个数字以链表逆序存储，
 */
public class AddList {

    public static void main(String[] args) {
        //数字

        Node pHead1 = new Node(-1);
        for(int i=0;i<6;i++) {
            Node tNode = new Node(new Random().nextInt(9));
            tNode.next = pHead1.next;
            pHead1.next = tNode;
        }
        Node pHead2 = new Node(-1);
        for(int i=0;i<9;i++) {
            Node tNode = new Node(new Random().nextInt(9));
            tNode.next = pHead2.next;
            pHead2.next = tNode;
        }
        print(pHead1);
        print(pHead2);

        Node sumNode = add(pHead1,pHead2);
        print(sumNode);
    }

    private static Node add(Node pHead1, Node pHead2) {
        Node p1 = pHead1.next;
        Node p2 = pHead2.next;
        Node sumNode = new Node(-1);
        Node curNode;
        Node tailNode = sumNode;
        int value;
        int carry = 0;
        while (p1!=null&&p2!=null) {
            value = p1.num + p2.num + carry;
            carry = value/10;
            value = value%10;
            curNode = new Node(value);
            tailNode.next = curNode;
            tailNode = curNode;
            p1 = p1.next;
            p2 = p2.next;
        }
        //处理较长
        Node p = p1==null?p2:p1;
        while (p!=null) {
            value = p.num + carry;
            carry = value / 10;
            value %= 10;
            curNode = new Node(value);
            tailNode.next = curNode;
            tailNode = curNode;
            p = p.next;
        }
        //处理进位
        if(carry != 0) {
            tailNode.next = new Node(carry);
        }
        return sumNode;
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
