package io.xiaoyao.algorithm.common;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason Xiao
 * @date 2019/9/17
 */
@Data
@NoArgsConstructor
public class ListNode {
    public Integer value;
    public ListNode next;

    public ListNode(Integer value) {
        this.value = value;
        this.next = null;
    }

    public ListNode(Integer... values) {
        if (values.length == 1) {
            this.value = values[0];
            this.next = null;
        } else {
            List<ListNode> list = new ArrayList<>();
            for (Integer integer : values) {
                ListNode n = new ListNode(integer);
                list.add(n);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }

            this.value = list.get(0).value;
            this.next = list.get(1);
        }

    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, 2, 3,3,2,1);
        System.out.println(root);
    }
}
