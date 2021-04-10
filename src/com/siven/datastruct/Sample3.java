package com.siven.datastruct;

/**
 * author siven
 * date: 2020/7/26
 * desc: 剑指 Offer 10- II. 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 0 <= n <= 100
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Sample3 {

    public static void main(String[] args) {
        System.out.println(numWays(5));
    }

    // 解题思路
    // 设跳上 n 级台阶有 f(n) 种跳法。在所有跳法中，青蛙的最后一步只有两种情况： 跳上 1 级或 2 级台阶。
    // 那么如果最后一步是1级，则有 f(n-1) 种跳法
    // 那么如果最后一步是2级，则有 f(n-2) 种跳法
    // 所以n级台阶总共会有 f(n) = f(n-1)+f(n-2)种跳法
    // 所以符合斐波那契数列

    // 推理：
    // f(n) = f(n-1)+f(n-2)
    // f(n+1) = f(n) + f(n-1)
    // 所以
    // sum = a + b
    // sum1 = sum + a;
    // f(0) = 0;
    // f(1) = 1
    // f(2) = f(1) + f(0) // 所以这里推导a起始值等于f(1)=1，b起始值为f(0)=0,i从2开始，结束为n+1

    // 总结斐波那契数列
    // 1. 推导 sum = a + b的关系
    // 2. 推导 a、b的起始值、遍历i起始值，结束为n+1
    static public int numWays(int n) {
        int sum = n;
        int a = 1;
        int b = 0;
        if (n > 1) {
            for (int i = 2; i <= n+1; i++) {
                sum = (a + b) % 1000000007;
                b = a;
                a = sum;
            }
        }
        return sum;
    }
}
