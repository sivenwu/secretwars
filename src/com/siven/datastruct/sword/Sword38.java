package com.siven.datastruct.sword;

import com.siven.datastruct.sword.util.Log;

import java.lang.reflect.Array;
import java.util.*;

/**
 * create time : 2021/7/14
 * coding : siven
 * description : 剑指 Offer 38. 字符串的排列 -- 经典回溯算法案例，参考Sword34思路
 * <p>
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword38 {

    public static void main(String[] args) {
        String[] res = new Solution().permutation("dkjphedy");
        Log.i(res.toString());
    }

    static class Solution {
        public String[] permutation(String s) {

            char[] source = s.toCharArray();
            boolean[] use = new boolean[source.length];
            dfs(0,source,use);
            return result.toArray(new String[result.size()]);
        }

        // "dkjphedy" 执行超出时间限制
        private List<String> result = new ArrayList<>();
        private StringBuffer path = new StringBuffer();
        private Set<String> record = new HashSet<String>(); // set的查找效率高点
        public void dfs(int depth,char[] source,boolean[] use){
            // 1.终止条件是dfs深度等于数组长度
            if (depth == source.length){
                String pathRes = new String(path);
                if (!record.contains(pathRes)){
                    // 题目中结果不能重复，所以这里做一个判断
                    result.add(pathRes);
                    record.add(pathRes);
                }
                return;
            }
            for (int i = 0;i<source.length;i++){
                if (!use[i]){
                    // 回溯三步走1-3
                    // 1. 选择
                    path.append(source[i]);
                    use[i] = true;
                    // 2. 递归
                    dfs(depth+1,source,use);
                    // 3. 撤销选择
                    path.deleteCharAt(path.length()-1);
                    use[i] = false;
                }
            }
        }
    }

}
