package com.siven.datastruct.sword;

import java.util.Stack;

/**
 * author siven
 * date: 2021/4/7
 * desc: 一句话概括
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Sword9 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);
        cQueue.appendTail(5);
        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            int result = -1;
            if (!stack1.isEmpty()) {
                // 将栈1数据拷贝到栈2
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                // 队头
                result = stack2.pop();
                // 恢复栈1
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }
            return result;
        }

        /**
         * 官方解题思路
         * @return
         */
        public int deleteHead2() {
            int result = -1;
            if(stack2.isEmpty()){
                // 将栈1数据拷贝到栈2，此时stack2第一个出栈就是队头
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            // 队头
            if (!stack2.isEmpty()) {
                result = stack2.pop();
            }
            return result;
        }
    }

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */

}
