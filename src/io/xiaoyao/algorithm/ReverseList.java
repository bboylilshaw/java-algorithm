package io.xiaoyao.algorithm;

import io.xiaoyao.algorithm.common.ListNode;

/**
 * 反转链表
 */
public class ReverseList {

    public static ListNode reverse(ListNode head) {
        ListNode preListNode = null;
        ListNode nowListNode = head;

        while (nowListNode != null) {
            ListNode nextListNode = nowListNode.next;   //保存下一个结点
            nowListNode.next = preListNode;             //当前结点指向前一个结点
            preListNode = nowListNode;                  //前任结点 到现任节点
            nowListNode = nextListNode;					//现任节点到下一结点
        }

        return preListNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, 2, 3);
        System.out.println(reverse(head));
    }
}
