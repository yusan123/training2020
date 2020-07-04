package com.yu.day0610;

import java.util.StringJoiner;

/**
 * @Author yu
 * @DateTime 2020/6/10 18:31
 */
public class T2 {

    public static void main(String[] args) {
        Node node1 = intToList(342);
        Node node2 = intToList(465);

        printList(operate(node1, node2));
    }

    //链表转换为数字后求和再转为链表返回
    public static Node operate(Node n1, Node n2) {
        Integer i1 = listToInt(n1);
        Integer i2 = listToInt(n2);
        Integer plus = i1 + i2;
        return intToList(plus);
    }


    //将链表转换为数字
    public static Integer listToInt(Node a) {
        StringBuilder sb = new StringBuilder();
        Node cur = a;
        while (cur.getNext() != null) {
            sb.insert(0, cur.getValue());
            cur = cur.getNext();
        }
        return Integer.parseInt(sb.toString());
    }

    //将数字转换为链表
    public static Node intToList(Integer num) {
        StringBuilder builder = new StringBuilder(num.toString()).reverse();
        String[] split = builder.toString().split("");
        Node<Integer> head = new Node<>();
        Node<Integer> result = head;
        for (String s : split) {
            int i = Integer.parseInt(s);
            head.setValue(i);
            Node<Integer> next = new Node<>();
            head.setNext(next);
            head = next;
        }
        return result;
    }

    //打印链表
    public static void printList(Node head) {
        StringJoiner sj = new StringJoiner("->");
        Node cur = head;
        while (cur.getNext() != null) {
            sj.add(cur.getValue().toString());
            cur = cur.getNext();
        }
        System.out.println(sj);
    }


    static class Node<Integer> {
        private Integer value;
        private Node next;

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

    }
}
