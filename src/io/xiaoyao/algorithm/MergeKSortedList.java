package io.xiaoyao.algorithm;

import io.xiaoyao.algorithm.common.ListNode;

/**
 * 合并k个已排序的list， leetcode 23
 * <p>
 * 时间复杂度 O(nlogk) n 为每个list元素个数，k为list个数
 * 空间复杂度 O(n)
 */
public class MergeKSortedList {


    /**
     * 分治法
     */
    public static ListNode sort(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return sort(lists, 0, lists.length - 1);
    }

    private static ListNode sort(ListNode[] lists, int low, int high) {
        if (low >= high) return lists[low];
        int mid = (low + high) / 2;
        ListNode l1 = sort(lists, low, mid);
        ListNode l2 = sort(lists, mid + 1, high);
        return merge(l1, l2);
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.value < l2.value) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }



    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, 4, 7);
        ListNode l2 = new ListNode(4, 8, 12);
        ListNode l3 = new ListNode(9, 33, 35);

        ListNode[] lists = {l1, l2, l3};
        ListNode sort = sort(lists);
        System.out.println(sort);
    }

}
