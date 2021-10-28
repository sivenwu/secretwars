package com.siven.datastruct.sword;

/**
 * create time : 2021/7/27
 * coding : siven
 * description : 剑指 Offer 46. 把数字翻译成字符串
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”
 * ，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *
 * f(n) =
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword46 {

    public static void main(String[] args) {
        System.out.println(new Solution().translateNum(12258));
    }

    static class Solution {
        // 青蛙跳动态规划一样，只是要处理小于等于25(z)和大于等于10(j)的情况
        public int translateNum1(int num) {
            if (num < 10) {
                return 1;
            }
            char[] chars = String.valueOf(num).toCharArray();
            int a = 1, b = 1;
            int res;
            for (int i = 1; i < chars.length; ++i) {
                res = chars[i - 1] == '1' || chars[i - 1] == '2' && chars[i] < '6' ? a + b : b;
                a = b;
                b = res;
            }
            return b;
        }

        /**
         * 类似青蛙跳，状态方程式推到
         * 案例：12258，有五种解法，抽象分析：
         * f(5) = f(4) // 如果最后一个数组不能组成>=10&<=25，则f(5)的解法只有f(4)的解法
         * f(5) = f(3) (如果刚好满足第5和第四个组成是>=10&<=25,则成立)
         * 导出：
         * f(n) = f(n-1) + f(n-2) ->(如果刚好满足第5和第四个组成是>=10&<=25,则成立)
         * @param num
         * @return
         */
        public int translateNum(int num) {
            if (num < 10){
                return 1;
            }
            // 加上"0"为了下面i-2不会越界，学习大神的~
            char[] chars = ("0"+num).toCharArray();
            int[] dp = new int[chars.length];
            dp[0] = 1;
            for(int i = 1;i<chars.length;i++){
                char curChar = chars[i];
                char beforChar = chars[i-1];
                dp[i] = dp[i-1];
                if (Integer.parseInt(beforChar+ "" + curChar) >= 10 && Integer.parseInt(beforChar+ "" + curChar)<=25){
                    dp[i]+=dp[i-2];
                }
            }
            return dp[dp.length-1];
        }

        // 交换法，减少内存
        //  f(n) = f(n-1) + f(n-2) ->(如果刚好满足第5和第四个组成是>=10&<=25,则成立)
        // sum = a + b
        public int translateNumSwap(int num) {
            if (num < 10){
                return 1;
            }
            // 加上"0"为了下面i-2不会越界，学习大神的~
            char[] chars = ("0"+num).toCharArray();
            int sum = 1;
            int a = 1;
            int b = 1;
            for(int i = 2;i<chars.length;i++){
                char curChar = chars[i];
                char beforChar = chars[i-1];
                b = a;
                if (Integer.parseInt(beforChar+ "" + curChar) >= 10 && Integer.parseInt(beforChar+ "" + curChar)<=25){

                }
            }
            return sum;
        }
    }

}
