package com.sangsang.arithmetic.daimasuixianglu.link.removenode;

import lombok.Data;

/**
 * 移除链表的元素
 * 题意：删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例 1：
 * 输入：head = [1,2,6,3,4,5,6], val = 6
 * 输出：[1,2,3,4,5]
 * <p>
 * 示例 2：
 * 输入：head = [], val = 1
 * 输出：[]
 * <p>
 * 示例 3：
 * 输入：head = [7,7,7,7], val = 7
 * 输出：[]
 *
 * @author liutangqi
 * @date 2023/2/17 10:43
 */
public class _0203RemoveNode {
    /**
     * 思路： 移除链表元素的时候需要考虑是否为头结点，头结点的时候处理方式和其它节点不同，因为头节点没有上一个节点，所以没办法将上一个节点和需要移除的下一个节点相连接
     * 解决方案：
     * 构造一个虚拟头节点，将头节点拼接到我们构建的虚拟头节点中，这样就不用考虑头节点的问题
     **/
    public static void main(String[] args) {
        //获取一个链表
        Node head = getLink(1, 2, 3);
        Node node = removeNode(head, 1);
        System.out.println(node);

    }

    /**
     * 移除目标链表的指定所有值
     *
     * @author liutangqi
     * @date 2023/2/17 11:07
     * @Param [head 链表头节点, itemValue 目标值]
     **/
    public static Node removeNode(Node head, Integer itemValue) {
        //构建一个虚拟节点
        Node weakNode = new Node(null);
        weakNode.next = head;
        //遍历链表，移除指定值
        Node tmpNode = weakNode;
        while (tmpNode.next != null) {
            //注意：这里是判断的下一个节点，因为头节点是我们的虚拟节点，不需要判断，这样while条件后面刚好可以把整个处理完，while只能循环到当前链表的倒数第二个节点，处理next的刚好处理完最后一个
            Node nextNode = tmpNode.next;
            if (nextNode.value != null && nextNode.value == itemValue) {
                tmpNode.next = nextNode.next;
            }
            tmpNode = nextNode;
        }
        //返回next的，这样刚好避开了我们创建的虚拟头节点
        return weakNode.next;
    }


    /**
     * 获取一个链表
     *
     * @author liutangqi
     * @date 2023/2/17 10:50
     * @Param [vals]
     **/
    public static Node getLink(int... vals) {
        if(vals.length==0){
            return null;
        }
        Node head = new Node(vals[0]);
        Node pre = head;
        for (int i = 1; i < vals.length; i++) {
            Node node = new Node(vals[i]);
            pre.next = node;
            pre = node;
        }
        return head;
    }

    @Data
    static class Node {
        /**
         * 每个节点存储的具体数据
         */
        private Integer value;
        /**
         * 下一个节点
         */
        private Node next;

        public Node(Integer val) {
            this.value = val;
        }
    }
}
