package com.mtinsky.algorithm.list;

/**
 * 已排序链表的去重，所有重复的远元素都删除
 */
public class SortListDuplicateRemoval2 {
    public static void main(String[] args) {
        int[] value = new int[]{9,9,9,8,8,5,5,4,4,3,2,1};
        Node pHead = new Node(-1);
        for(int i=0;i<12;i++) {
            Node tNode = new Node(value[i]);
            tNode.next = pHead.next;
            pHead.next = tNode;
        }
        print(pHead);

        Node pre = pHead;
        Node cur = pHead.next;
        boolean dup = false;
        Node next;
        while (cur!=null) {
            dup = false;
            next = cur.next;
            while (next!=null&&next.num == cur.num) {
                pre.next = next;
                next = next.next;
                cur = next;
                dup = true;
            }
            if(dup) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
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
