package com.siven.datastruct.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * create time : 2021/8/9
 * coding : siven
 * description : 剑指 Offer 48. 最长不含重复字符的子字符串
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword48 {

    public static void main(String[] args) {
        int r = new Solution().lengthOfLongestSubstring("abcabcbb");
        System.out.println(r);
    }

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
//            public int lengthOfLongestSubstring(String s) {
//                int result = 0;
//                for(int i = 0;i<s.length();i++){
//                    char start = s.charAt(i);
//                    List<Character> list = new ArrayList<>();
//                    list.add(start);
//                    for(int j = i+1;j<s.length();j++){
//                        char end = s.charAt(j);
//                        if(list.contains(end)){
//                            break;
//                        }
//                        list.add(end);
//                    }
//                    if(result < list.size()){
//                        result = list.size();
//                    }
//                }
//                return result;
            return 0;
        }
    }
}
