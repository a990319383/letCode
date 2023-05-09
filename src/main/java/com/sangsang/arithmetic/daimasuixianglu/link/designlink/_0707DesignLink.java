package com.sangsang.arithmetic.daimasuixianglu.link.designlink;

import jdk.internal.org.objectweb.asm.Handle;
import lombok.Data;

/**
 * 设计链表
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * @author liutangqi
 * @date 2023/2/20 10:57
 */
public class _0707DesignLink {


    public static void main(String[] args) {
        Node link = getLink(1, 2, 3);
//        System.out.println(link.get(2));
//        System.out.println(link.addAtHead(0));
//        System.out.println(link.addAtTail(4));
//        System.out.println(link.addAtIndex(3, 0));
        System.out.println(link.deleteAtIndex(1));

    }


    /**
     * 获取一个链表的头节点
     *
     * @param vals
     * @return
     */
    public static Node getLink(Integer... vals) {
        if (vals.length == 0) {
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
        private Integer value;
        private Node next;

        public Node(Integer value) {
            this.value = value;
        }

        /**
         * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
         *
         * @author liutangqi
         * @date 2023/2/20 11:04
         * @Param [index 索引值]
         **/
        public Integer get(Integer index) {
            if (index == 0) {
                return this.value;
            }
            int i = 1;
            Node tmp = this.next;
            while (tmp != null) {
                if (i == index) {
                    return tmp.value;
                }
                i++;
                tmp = tmp.next;
            }
            //未找到，返回-1
            return -1;
        }

        /**
         * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
         *
         * @author liutangqi
         * @date 2023/2/20 11:17
         * @Param [val]
         **/
        public Node addAtHead(Integer val) {
            //新的头节点
            Node newHead = new Node(val);
            newHead.next = this;
            return newHead;
        }

        /**
         * 将值为 val 的节点追加到链表的最后一个元素。
         *
         * @author liutangqi
         * @date 2023/2/20 11:24
         * @Param [val]
         **/
        public Node addAtTail(Integer val) {
            //添加虚拟头节点，避免头值的处理
            Node weakHead = this.addAtHead(null);
            Node tmp = weakHead.next;
            while (tmp != null) {
                if (tmp.next == null) {
                    tmp.next = new Node(val);
                    break;
                }
                tmp = tmp.next;
            }
            return weakHead.next;
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
         *
         * @author liutangqi
         * @date 2023/2/20 11:29
         * @Param [index, val]
         **/
        public Node addAtIndex(Integer index, Integer val) {
            //1.index 小于等于0 在头部插入
            if (index <= 0) {
                Node node = new Node(val);
                node.next = this;
                return node;
            }

            //2.中间位置插入
            //当前循环的下标值
            int i = 0;
            Node curNode = this;
            Node preNode = null;
            //这里循环条件是当前节点不为空，这样最后一个节点也会在循环条件中进行处理
            while (curNode != null) {
                if (i == index) {
                    //将新节点前后拼接在一起，上面做了index<=0 的处理，所以这里不存在头结点的问题
                    Node node = new Node(val);
                    node.next = curNode;
                    preNode.next = node;
                    // 注意：这里返回的是this,只要不是头插，最后返回的都是this
                    return this;
                }
                i++;
                preNode = curNode;
                curNode = curNode.next;
            }

            //3.尾部插入
            //想要插入的地方等于链表长度
            if (i == index) {
                Node node = new Node(val);
                preNode.next = node;
                //注意：这里返回的是this ，不是最后一个节点
                return this;
            }

            //index 大于链表长度，不插入
            return this;
        }

        /**
         * 如果索引 index 有效，则删除链表中的第 index 个节点。
         *
         * @author liutangqi
         * @date 2023/5/9 17:21
         * @Param [index]
         **/
        public Node deleteAtIndex(Integer index) {
            //构建虚拟头结点，避免头结点的特殊处理
            Node weakNode = new Node(null);
            weakNode.next = this;

            //当前循环下标，从虚拟节点下一个开始循环
            int i = 0;
            //当前循环的节点
            Node curNode = this;
            Node preNode = weakNode;
            while (curNode != null) {
                if (i == index) {
                    preNode.next = curNode.next;
                }
                i++;
                preNode = curNode;
                curNode = curNode.next;
            }
            return weakNode.next;
        }
    }
}
