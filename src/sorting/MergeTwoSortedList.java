package sorting;

import common.ListNode;

/**
 * 合并两个已排序的链表  leetcode 21
 *
 * 时间复杂度： O(n)
 * 空间复杂度： O(1) / O(n) 当用原链表时是O(1)， 新建一个链表是O(n)
 */
public class MergeTwoSortedList {

    //非递归
    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.value < l2.value) {
                cur.next = new ListNode(l1.value);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.value);
                l2 = l2.next;
            }
            cur = cur.next;
        }

        while (l1 != null) {
            cur.next = new ListNode(l1.value);
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            cur.next = new ListNode(l2.value);
            l2 = l2.next;
            cur = cur.next;
        }

        return dummy.next;
    }

    //递归
    public static ListNode mergeTwoSortedListRecursively(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.value < l2.value) {
            l1.next = mergeTwoSortedListRecursively(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedListRecursively(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, 4, 6);
        ListNode l2 = new ListNode(1, 3, 5, 7);
        ListNode root = mergeTwoSortedList(l1, l2);
        ListNode root1 = mergeTwoSortedListRecursively(l1, l2);
        System.out.println(root);
    }
}
