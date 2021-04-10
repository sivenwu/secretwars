package com.siven.datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 * <p>
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 举例子：0 1 1 2 3 5 8 13 21 34 55
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Sample2 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(fib(44) + "耗时：" + (System.currentTimeMillis() - start)); // 701408733耗时：2978
        System.out.println(fib2(45) + "耗时：" + (System.currentTimeMillis() - start));   // 701408733耗时：0
//        System.out.println(fib3(44) + "耗时：" + (System.currentTimeMillis() - start)); // 433494437耗时：0
    }

    // 递归法 - 超出执行时间限制..
    public static int fib(int n) {
        if (n > 1) {
            return (fib(n - 1) + fib(n - 2)) % 1000000007;
        }
        return n;
    }

    // 优化1 记忆递归法（原理：用一个数组存储记录f(n)的值，避免重复计算）
    private static Map<Integer, Integer> record = new HashMap<>();

    public static int fib2(int n) {
        if (n > 1) {
            if (record.containsKey(n)) {
                return record.get(n);
            }
            int result = (fib2(n - 1) + fib2(n - 2)) % 1000000007;
            record.put(n, result);
            return result;
        }

        return n;
    }

    // 优化2！ 动态规划 以斐波那契数列性质 f(n + 1) = f(n) + f(n - 1)f(n+1)=f(n)+f(n−1) 为转移方程
    // 思路：观察规律
    // f(n) = f(n-1) + f(n-2)  ->  sum = a + b
    // f(n+1) = f(n) + f(n-1)  -> sum1 = sum + a
    // 因此找到规律
    // 抽象来看 在进行sum=a+b后，下一次结果的a等于上一次的sum,b等于上一次的a,一次类推自上到下交换位置接口，这样比优化1更省内存空间
    //
    public static int fib3(int n) {
        int sum = 0;
        int a = 0;
        int b = 1;
        if (n > 0) {
            for (int i = 1; i <= n; i++) {
                sum = (a + b) % 1000000007;
                b = a;
                a = sum;
            }
        }
        return sum;
    }
}
