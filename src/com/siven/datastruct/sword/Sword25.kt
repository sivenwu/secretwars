package com.siven.datastruct.sword

import com.siven.datastruct.models.ListNode

/**
 * create time : 2021/6/9
 * coding : siven
 * description :
 *
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
object Sword25 {

    @JvmStatic
    fun main(args: Array<String>) {

    }

    class Solution {
        fun mergeTwoLists(l1: ListNode, l2: ListNode): ListNode {
            var listNode1: ListNode? = l1
            var listNode2: ListNode? = l2
            // 1. 判空
            if (listNode1 == null) {
                return l2
            }
            if (listNode2 == null) {
                return l1
            }
            // 2. 遍历
            var root = ListNode(0)
            var tempNode: ListNode? = root
            while (listNode1 != null && listNode2 != null) {
                if (listNode1.`val` >= listNode2.`val`) {
                    tempNode?.next = listNode2
                    listNode2 = listNode2?.next
                } else {
                    tempNode?.next = listNode1
                    listNode1 = listNode1?.next
                }
                // 3. 更新下一个节点
                tempNode = tempNode?.next
            }

            // 4.处理剩下节点
            if(listNode1 != null){
                tempNode?.next = listNode1
                tempNode = tempNode?.next
            }

            if(listNode2 != null){
                tempNode?.next = listNode2
                tempNode = tempNode?.next
            }

            return root.next!!
        }

        fun mergeTwoLists2(l1: ListNode?, l2: ListNode?): ListNode? {
            var listNode1: ListNode? = l1
            var listNode2: ListNode? = l2
            // 1. 判空
            if (listNode1 == null) {
                return l2
            }
            if (listNode2 == null) {
                return l1
            }
            // 2. 递归遍历，抽象理解是一直找头结点
            var root: ListNode? = null
            if (listNode1.`val` < listNode2.`val`){
                root = listNode1
                root.next = mergeTwoLists2(root?.next,listNode2)
            }else{
                root = listNode2
                root.next = mergeTwoLists2(root?.next,listNode1)
            }

            return root
        }
    }
}