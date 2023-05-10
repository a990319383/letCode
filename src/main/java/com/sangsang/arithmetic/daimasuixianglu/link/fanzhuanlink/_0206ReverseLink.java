package com.sangsang.arithmetic.daimasuixianglu.link.fanzhuanlink;

import lombok.Data;

/**
 * 题意：反转一个单链表。
 * <p>
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * <p>
 * 分析：再定义一个新的链表很浪费空间，只需要改变next指针指向即可
 *
 * @author liutangqi
 * @date 2023/5/10 10:38
 */
public class _0206ReverseLink {

    public static void main(String[] args) {
        Node link = getLink(1, 2, 3);
        System.out.println(link.reverseLink());
    }


    @Data
    public static class Node {
        private Integer value;
        private Node next;

        public Node(Integer val) {
            this.value = val;
        }

        /**
         * 反转链表
         * 定义两个指针，保存循环的两个节点，将这两个节点的指向交换
         *
         * @author liutangqi
         * @date 2023/5/10 10:49
         * @Param [node]
         **/
        public Node reverseLink() {
            //当前节点
            Node curNode = this;
            //前一个节点
            Node preNode = null;
            //下一个节点
            Node nextNode = null;
            while (curNode != null) {
                //暂时保存下一个节点，因为反转节点后找不到旧的上一个节点了
                nextNode = curNode.next;
                //交换当前节点和前一个节点指针
                curNode.next = preNode;
                //遍历
                preNode = curNode;
                curNode = nextNode;
            }
            return preNode;
        }
    }

    /**
     * 构建一个链表
     *
     * @author liutangqi
     * @date 2023/5/10 10:41
     * @Param [val]
     **/
    public static Node getLink(Integer... vals) {
        if (vals.length == 0) {
            return null;
        }
        Node head = new Node(vals[0]);
        Node pre = head;
        for (int i = 1; i < vals.length; i++) {
            pre.next = new Node(vals[i]);
            pre = pre.next;
        }
        return head;
    }
}
