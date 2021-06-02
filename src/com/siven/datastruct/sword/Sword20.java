package com.siven.datastruct.sword;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 *
 * 数值（按顺序）可以分成以下几个部分：
 *
 * 若干空格
 * 一个小数或者整数
 * （可选）一个'e'或'E'，后面跟着一个整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 *
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 *
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 *
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 * 
 *
 * 示例 1：
 *
 * 输入：s = "0"
 * 输出：true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword20 {
    public static void main(String[] args) {
        new Solution().isNumber("0E");
    }

   public static class Solution {
        // 完全是穷举了
        public boolean isNumber(String s) {
            if (s == null || s.length() ==0){
                return false;
            }
            s = s.trim(); // 去掉无效空格
            char[] chars = s.toCharArray();
            boolean isNum = false; // 是否是数字
            boolean isE = false; // 是否是e
            boolean isDot = false; // 是否是点
            for(int i = 0;i<chars.length;i++){
               if (chars[i] >= '0' && chars[i] <= '9'){
                   isNum = true;
               }else if (chars[i] == '.' && !isDot && !isE){
                   //判定为.  需要没出现过.并且没出现过e
                   isDot = true;
               }else if ((chars[i] == 'e' || chars[i] == 'E') && !isE && isNum){
                   // （可选）一个'e'或'E'，后面跟着一个整数
                   // 只能一个e或者出现过数字
                   isE = true;
                   isNum = false;
               }else if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E')) {
                   //其他情况，都是非法的
               } else {
                   return false;
               }
            }
            return isNum;
        }
    }
}
