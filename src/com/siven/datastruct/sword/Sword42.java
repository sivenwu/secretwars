package com.siven.datastruct.sword;

import java.util.ArrayList;
import java.util.List;

/**
 * create time : 2021/7/24
 * coding : siven
 * description : 剑指 Offer 42. 连续子数组的最大和 (动态规划)
 *
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword42 {
    /**
     * 例如 [1,2,-3,4]
     * f(2) = 1 + 2 + (-3)
     * f(1) = 1 + 2
     * 导出 f(2) = f(1) +nums[2]
     * 导出 f(n) = f(n-1) + nums[n]
     * f(n)的最大解取决于f(n-1) + nums[n]，或 nums[n]
     * 导出 f(n) = max(f(n-1) + nums[n],nums[n])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int pre = 0;
        for (int i = 0;i<nums.length;i++) {
            pre = Math.max(nums[i]+pre,nums[i]);
            max = Math.max(max,pre);
        }
        return max;
    }
}
