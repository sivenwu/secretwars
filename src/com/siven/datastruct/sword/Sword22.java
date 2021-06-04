package com.siven.datastruct.sword;

import com.siven.datastruct.models.ListNode;

/**
 * create time : 2021/6/4
 * coding : siven
 * description :
 * 剑指 Offer 22. 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword22 {
    public static void main(String[] args) {

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode getKthFromEnd(ListNode head, int k) {
            // 方案1：1.遍历求链表长度 2.通过再次循环找到len-k的节点
            int length = 1; // 题目了解链表至少为1
            ListNode node = head;
            while(node.getNext() != null){
                length++;
                node = node.getNext();
            }

            ListNode result = null;
            if (length > 0){
                result = head;
                for (int i = 1; i <= length - k; i++) {
                    result = result.getNext();
                }
            }
            return result;
        }

        public ListNode getKthFromEnd2(ListNode head, int k) {
            // 方案2：首尾双指针解法
            // 可能要画个图才知道，举例：子链表 1、2、3、4、5，要求找到倒数第2个节点
            // 解法：
            // 首先right节点先找到第2个节点，即遍历到2这个节点
            // 最后拿到这个节点，直至到尾节点，总共遍历了4次，这时候left也跟随走了四次，这时候拿到的结果很意外就是倒数第二个节点4了！
            ListNode left = head;
            ListNode right = head;
            for (int i = 1;i<k;i++){
                right = right.getNext();
            }
            while(right.getNext() != null){
                left = left.getNext();
                right = right.getNext();
            }
            return left;
        }
    }
}
