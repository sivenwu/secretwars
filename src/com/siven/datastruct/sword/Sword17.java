package com.siven.datastruct.sword;

/**
 * create time : 5/24/21
 * coding : siven
 * description :
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *  
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword17 {


    public static class Solution {
        public int[] printNumbers(int n) {
            if(n <= 0){
                return null;
            }
            // 10的n次方  -1
            // 1. 快速幂算出10的n次方
            int target = 1;
            int base = 10;
            while(n > 0){
                if((n & 1) == 1){
                    target = target * base;
                }
                base = base * base;
                n>>=1;
            }
            // 2. 输出结果
            target = target -1; // 10的n次方结果  -1
            int[] result = new int[target];
            for(int i = 0;i<target;i++){
                result[i]=i+1;
            }
            return result;
        }
    }

}
