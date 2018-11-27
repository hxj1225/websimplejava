package com.hxj.websimplejava.algorithm;

import lombok.Data;

/**
 * ����ת
 *
 * @author xiangjun.hexj
 * @date 2018/10/23 21:30
 */
@Data
public class ListReverse {

    /**
     * ��������node�ڵ�
     */
    @Data
    public static class OneWayNode {

        private int        index;
        private OneWayNode next;

        /**
         * �ݹ鷨
         * 
         * @param node
         * @return
         */
        public static OneWayNode reverse(OneWayNode node) {
            if (node == null || node.getNext() == null) {
                return node;
            }
            // �ȷ�ת�����ڵ�head.getNext()
            OneWayNode reHead = reverse(node.getNext());
            // ����ǰ����ָ����ָ��ǰһ���
            node.getNext().setNext(node);
            // ǰһ����ָ������Ϊnull;
            node.setNext(null);
            return reHead;
        }

        /**
         * ������
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
                // ������һ���ڵ�
                next = head.next;
                // ����next
                head.next = prev;
                // ���浱ǰ�ڵ�
                prev = head;
                // ʣ�½ڵ�
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
