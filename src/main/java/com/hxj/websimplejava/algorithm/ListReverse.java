package com.hxj.websimplejava.algorithm;

import lombok.Data;

/**
 * 链表反转
 *
 * @author xiangjun.hexj
 * @date 2018/10/23 21:30
 */
@Data
public class ListReverse {

    /**
     * 单项链表node节点
     */
    @Data
    public static class OneWayNode {

        private int        index;
        private OneWayNode next;

        /**
         * 递归法
         * 
         * @param node
         * @return
         */
        public static OneWayNode reverse(OneWayNode node) {
            if (node == null || node.getNext() == null) {
                return node;
            }
            // 先反转后续节点head.getNext()
            OneWayNode reHead = reverse(node.getNext());
            // 将当前结点的指针域指向前一结点
            node.getNext().setNext(node);
            // 前一结点的指针域令为null;
            node.setNext(null);
            return reHead;
        }

        /**
         * 遍历法
         * 
         * @param head
         * @return
         */
        public static OneWayNode reverse2(OneWayNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            OneWayNode prev = null;
            OneWayNode next = head.getNext();
            while (next != null) {
                // 保存下一个节点
                next = head.next;
                // 重置next
                head.next = prev;
                // 保存当前节点
                prev = head;
                // 剩下节点
                head = next;
            }
            head.next = prev;
            return head;
        }

        public static OneWayNode prepareData() {
            OneWayNode linkNode1 = new OneWayNode();
            linkNode1.index = 1;
            OneWayNode linkNode2 = new OneWayNode();
            linkNode2.index = 2;
            OneWayNode linkNode3 = new OneWayNode();
            linkNode3.index = 3;
            OneWayNode linkNode4 = new OneWayNode();
            linkNode4.index = 4;
            OneWayNode linkNode5 = new OneWayNode();
            linkNode5.index = 5;
            OneWayNode linkNode6 = new OneWayNode();
            linkNode6.index = 6;
            linkNode1.next = linkNode2;
            linkNode2.next = linkNode3;
            linkNode3.next = linkNode4;
            linkNode4.next = linkNode5;
            linkNode5.next = linkNode6;
            return linkNode1;
        }

        public static void main(String[] a) {
            OneWayNode linkNode1 = OneWayNode.prepareData();
            System.out.println(linkNode1);

            OneWayNode newNode = OneWayNode.reverse2(linkNode1);
            System.out.println(newNode);
        }
    }

}
