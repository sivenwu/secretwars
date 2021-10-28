package com.siven.datastruct.sword;

import java.util.Arrays;

/**
 * create time : 2021/7/16
 * coding : siven
 * description : 剑指 Offer 40. 最小的k个数
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword40 {

    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            int[] res = new int[k];
            if (k <= arr.length) {
                Arrays.sort(arr);
                for (int i = 0; i < k; i++) {
                    res[i] = arr[i];
                }
            }
            return res;
        }
    }
}
