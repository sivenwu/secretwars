package com.siven.datastruct.sword;

import com.siven.datastruct.sword.util.Log;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * create time : 2021/6/15
 * coding : siven
 * description : 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 * <p>
 * 提示：
 * <p>
 * 各函数的调用总次数不超过 20000 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword30 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        Log.i("" + minStack.min());
        minStack.pop();
        Log.i("" + minStack.top());
        Log.i("" + minStack.min());
    }

    public static class MinStack {

        private static final int MAX_SIZE = 10;
        private int[] arrays;
        private int curIndex = 0;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            arrays = new int[MAX_SIZE];
        }

        public void push(int x) {
            if (curIndex == arrays.length - 1) {
                // 拓展数组
                int tmp[] = new int[arrays.length * 2];
                System.arraycopy(arrays, 0, tmp, 0, arrays.length);
                arrays = tmp;
            }
            arrays[curIndex++] = x;
        }

        public void pop() {
            if (curIndex > 0) {
                arrays[--curIndex] = 0;
            }
        }

        public int top() {
            if (curIndex > 0) {
                return arrays[--curIndex];
            }
            return 0;
        }

        public int min() {
            int min = 0;
            for (int i = 0; i <= curIndex; i++) {
                if (min > arrays[i]) {
                    min = arrays[i];
                }
            }
            return min;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */

}
