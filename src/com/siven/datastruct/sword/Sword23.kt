package com.siven.datastruct.sword

import com.siven.datastruct.models.ListNode

/**
 * create time : 2021/6/7
 * coding : siven
 * description : 翻转链表
 */
object Sword23 {

    @JvmStatic
    fun main(args: Array<String>) {
        var head = ListNode(1)
        var node = head
        node.next = ListNode(2)
        node = node.next!!
        node.next = ListNode(3)
        node = node.next!!
        node.next = ListNode(4)
        node = node.next!!
        node.next = ListNode(5)
        print(Sword23.reverseList(head))
    }

    // 第一次移动：
    // cur  pre
    // null->1->2->3->4->5
    // 第二次移动和修改指向：
    //      cur pre
    // null<-1 2->3->4->5
    // 结果：
    // null<-1<-2<-3<-4<-5
    fun reverseList(head:ListNode?):ListNode{
        head?.apply{
            var cur:ListNode? = null
            var pre:ListNode? = head
            while (pre != null) {
                var node = pre.next // 取出2
                pre.next = cur // pre指向cur(null)
                // 交换位置
                cur = pre
                pre = node
            }
            return cur!!
        }
        return ListNode(0)
    }
}