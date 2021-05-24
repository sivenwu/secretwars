package com.siven.datastruct.sword;

/**
 * create time : 5/20/21
 * coding : siven
 * description :
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class Sword15 {

    public static void main(String[] args) {
        System.out.println(Solution.hammingWeight(127));
    }

    /**
     * 这里要注意无符号
     */
    public static class Solution {
        // you need to treat n as an unsigned value
//        public static int hammingWeight(int n) {
//            // 自己没考虑好无符号~
//            int result = 0;
//            while(n > 0){
//                if(n % 2  == 1){
//                    result++;
//                }
//                n = n/2;
//            }
//            return result;
//        }

        /**
         * 按位与运算的方案
         * 思路：与1进行与运算，如果==1，说明最右边存在1，然后进行右移
         * @param n
         * @return
         */
//        public static int hammingWeight(int n) {
//            // 自己没考虑好无符号~
//            int result = 0;
//            while (n!=0){
//               result +=(n&1);
//               n  = n>>>1;  // java 无符号右移是>>>  !!!
//            }
//            return result;
//        }

        /**
         * n-1方案
         * 思路：
         *(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
         * n&(n−1) 解析： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
         *
         * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
         * @param n
         * @return
         */
        public static int hammingWeight(int n) {
            int result = 0;
            while (n!=0){
              result++;
              n=n&(n-1);
            }
            return result;
        }
    }
}
