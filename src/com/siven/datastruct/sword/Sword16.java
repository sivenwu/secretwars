package com.siven.datastruct.sword;

/**
 * create time : 5/24/21
 * coding : siven
 * description :
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，
 * 同时不需要考虑大数问题。
 */
public class Sword16 {

    public static void main(String[] args) {
        System.out.println(Solution.myPow(2,-2));
    }

    public static class Solution {
        // 以为可以用动态规划解决，常规方法有OOM风险
        public static double myPow(double x, int n) {
            // Integer.MAX_VALUE = 2^31-1 = 2147483647
            if(n == 0){
                return 1;
            }
            int length = n > 0?n:-n;
            double temp[] = new double[2];
            temp[0] = 1;
            temp[1] = x;
            for(int i = 0;i<length;i++){
                temp[1] = temp[0]*x;
                temp[0] = temp[1];
            }
            return n>0?(temp[0]):(1/temp[0]);
        }

        // 快速幂
        // https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/solution/jian-dan-li-jie-kuai-su-mi-by-ollieq-rl74/
        public static double myPow1(double x, int n){
            if (x == 0){
                return 0;
            }
            long b = n;
            double result = 1.0;
            if (b <0){
                x = 1/x;
                b = -b;
            }
            while (b > 0){
                if ((b & 1) == 1){
                    result = result*x;
                }
                x*=x;
                b = b>>1;
            }
            return result;
        }
    }

}
