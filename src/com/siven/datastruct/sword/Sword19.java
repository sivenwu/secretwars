package com.siven.datastruct.sword;

/**
 * create time : 5/26/21
 * coding : siven
 * description :
 *
 * 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（含0次）。在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母以及字符 . 和 *，无连续的 '*'。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword19 {


    class Solution {
        public boolean isMatch(String s, String p) {
            if (s == null || s.length() ==0){
                return false;
            }
            if (p == null || p.length() ==0){
                return false;
            }

            // 记录.的坐标
//            int pointIndexs[]
            return false;
        }

        public boolean isMatch_(String A, String B) {
            // 如果字符串长度为0，需要检测下正则串
            if (A.length() == 0) {
                // 如果正则串长度为奇数，必定不匹配，比如 "."、"ab*",必须是 a*b*这种形式，*在奇数位上
                if (B.length() % 2 != 0) return false;
                int i = 1;
                while (i < B.length()) {
                    if (B.charAt(i) != '*') return false;
                    i += 2;
                }
                return true;
            }
            // 如果字符串长度不为0，但是正则串没了，return false
            if (B.length() == 0) return false;
            // c1 和 c2 分别是两个串的当前位，c3是正则串当前位的后一位，如果存在的话，就更新一下
            char c1 = A.charAt(0), c2 = B.charAt(0), c3 = 'a';
            if (B.length() > 1) {
                c3 = B.charAt(1);
            }
            // 和dp一样，后一位分为是 '*' 和不是 '*' 两种情况
            if (c3 != '*') {
                // 如果该位字符一样，或是正则串该位是 '.',也就是能匹配任意字符，就可以往后走
                if (c1 == c2 || c2 == '.') {
                    return isMatch(A.substring(1), B.substring(1));
                } else {
                    // 否则不匹配
                    return false;
                }
            } else {
                // 如果该位字符一样，或是正则串该位是 '.'，和dp一样，有看和不看两种情况
                if (c1 == c2 || c2 == '.') {
                    return isMatch(A.substring(1), B) || isMatch(A, B.substring(2));
                } else {
                    // 不一样，那么正则串这两位就废了，直接往后走
                    return isMatch(A, B.substring(2));
                }
            }
        }
    }
}
