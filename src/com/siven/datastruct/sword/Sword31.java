package com.siven.datastruct.sword;

import com.siven.datastruct.sword.util.Log;

import java.util.Stack;

/**
 * create time : 2021/6/15
 * coding : siven
 * description : 剑指 Offer 31. 栈的压入、弹出序列
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，
 * 序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 *示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword31 {

    public static void main(String[] args) {

    }

    // 判断合不合法，用个栈试一试: 把压栈的元素按顺序压入，当栈顶元素和出栈的第一个元素相同，
    // 则将该元素弹出，出栈列表指针后移并继续判断。最后判断出栈列表指针是否指向出栈列表的末尾即可。
    // 自己的思路：
    // 1. 用一个栈去模拟入栈、出栈
    // 2. 入栈的时候判断是否在出栈当前位置里面，是的话，将这个栈pop
    // 3. 依次顺序完成入栈操作，如果当前入栈全部出栈了，说明符合结果
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int popIndex = 0;
            for (int i = 0;i<pushed.length;i++){
                stack.push(pushed[i]);
                while (stack.size() > 0 && (stack.peek() == popped[popIndex])){
                    stack.pop();
                    popIndex++;
                }
            }
            return stack.size() == 0;
        }
    }
}
