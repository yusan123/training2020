package com.yu.day0521;

import java.util.StringJoiner;

/**
 * @Author yu
 * @DateTime 2020/5/21 12:09
 */
public class SwapListNode {

    private static class ListNode {
        Integer val;
        ListNode next;

        public ListNode(Integer val) {
            this.val = val;
        }
    }

    ListNode head;

    /**
     * 交换链表相邻节点，不是交换值
     *
     * @param head
     * @return
     */
    public static ListNode swap(ListNode head) {
        ListNode dumb = new ListNode(0);
        dumb.next = head;
        ListNode tmp = dumb;
        while (tmp.next != null && tmp.next.next != null) {
            //需要交换的第一个节点
            ListNode cur = tmp.next;
            //需要交换的第二个节点
            ListNode next = tmp.next.next;
            //交换的逻辑
            cur.next = next.next;
            next.next = cur;
            tmp.next = next;
            tmp = tmp.next.next;
        }
        return dumb.next;
    }

    /**
     * 打印链表
     *
     * @param head
     */
    public static void show(ListNode head) {
        StringJoiner sj = new StringJoiner("->", "<head>", "<end>");
        ListNode cur = head;
        while (cur != null) {
            sj.add(cur.val.toString());
            cur = cur.next;
        }
        System.out.println(sj);
    }

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5, 7};
        ListNode head = new ListNode(ints[0]);
        ListNode cur = head;
        for (int i = 1; i < ints.length; i++) {
            cur.next = new ListNode(ints[i]);
            cur = cur.next;
        }

        show(head);
        ListNode swap = swap(head);
        show(swap);
    }
}
