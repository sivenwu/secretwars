package com.siven.datastruct.sword;

import java.util.HashMap;
import java.util.Map;

/**
 * create time : 2021/7/8
 * coding : siven
 * description :
 */
public class Sword35 {

    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        /**
         * node和randomnode关系
         */
        Map<Node, Node> nodeList = new HashMap();

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            // 1. 绑定好node和新节点的关系
            Node curNode = head;
            while(curNode != null){
                nodeList.put(curNode,new Node(curNode.val));
                curNode = curNode.next;
            }
            // 2. 构建新的node
            curNode = head;
            while(curNode != null){
                nodeList.get(curNode).next = nodeList.get(curNode.next);
                nodeList.get(curNode).random = nodeList.get(curNode.random);
            }
            return nodeList.get(head);
        }

//        private void findAndRecordRadom(Node head, Node curNode) {
//            Node node = head;
//            int i = 0;
//            if (curNode != null) {
//                while (node != null) {
//                    if (node == curNode.random) {
//                        nodeList.put(i, node);
//                        break;
//                    }
//                    node = node.next;
//                }
//            }
//
//        }
    }
}
