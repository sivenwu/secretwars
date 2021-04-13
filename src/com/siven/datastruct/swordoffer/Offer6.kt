package com.siven.datastruct.swordoffer

import com.siven.datastruct.models.ListNode
import com.siven.datastruct.utils.string
import java.lang.StringBuilder
import java.util.*

// 剑指 Offer 06. 从尾到头打印链表
// 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
object Offer6 {

    @JvmStatic
    fun main(args: Array<String>) {

        // test
        var head = ListNode(1)
        head.next = ListNode(3)
        head!!.next!!.next = ListNode(2)

        print(reversePrint(head).string())
    }

    /**
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     *
     * 思考：考虑到翻转输出，可以利用栈的思路，先进后出
     */
    fun reversePrint(head: ListNode?): IntArray {
        var result = IntArray(0)
        var stack = Stack<Int>()
        head?.apply {
            var node: ListNode? = this
            while (node != null) {
                stack.push(node.`val`)
                node = node!!.next
            }
            result = IntArray(stack.size)
            var i = 0
            while (!stack.empty()) {
                result.set(i, stack.pop())
                i++
            }
        }
        return result
    }

}
