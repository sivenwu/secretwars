package com.siven.datastruct.sword;

import java.util.Arrays;

/**
 * create time : 2021/7/15
 * coding : siven
 * description : 剑指 Offer 39. 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 *  
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword39 {

    class Solution {
        public int majorityElement(int[] nums) {
            // 效率太慢啦
            // int len = nums.length;
            // for(int i = 0;i<len;i++){
            //     int max = 0;
            //     int res = nums[i];
            //     for(int j = 0;j<len;j++){
            //         if(res == nums[j] && i != j){
            //             max++;
            //         }
            //         if(max >= len/2){
            //             return res;
            //         }
            //     }
            // }
            // return 0;

            // 先排序
            Arrays.sort(nums);
            int sum = 0;
            int len = nums.length;
            for(int i = 0;i<len-1;i++){
                if(nums[i] == nums[i+1]){
                    sum++;
                    if(sum >= len/2){
                        return nums[i];
                    }
                }else{
                    sum = 0;
                }
            }
            return nums[0];
        }
    }
}
