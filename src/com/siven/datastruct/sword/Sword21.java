package com.siven.datastruct.sword;

/**
 * create time : 2021/6/3
 * coding : siven
 * description :
 * 调整数组顺序使奇数位于偶数前面
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums =[1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 首尾双指针解法
 */
public class Sword21 {
    public static void main(String[] args) {

    }

    static class Solution {
        public int[] exchange(int[] nums) {
            int oddIndex = 0;
            int[] oddArray = new int[nums.length];
            int evenIndex = 0;
            int[] evenArray = new int[nums.length];
            for (int num : nums) {
                if(num % 2 != 0){
                    oddArray[oddIndex] = num;
                    oddIndex++;
                }else{
                    evenArray[evenIndex] = num;
                    evenIndex++;
                }
            }

            int startEventIndex = 0;
            for (int i = oddIndex;i<oddArray.length;i++){
                oddArray[i] = evenArray[startEventIndex];
                startEventIndex++;
            }

            return oddArray;
        }

        /**
         * 首尾双指针解法
         * @param nums
         * @return
         *
         * 定义头指针 left ，尾指针 right .
         * left 一直往右移，直到它指向的值为偶数
         * right一直往左移， 直到它指向的值为奇数
         * 交换 nums[left] 和 nums[right] .
         * 重复上述操作，直到 left == righ.
         */
        public int[] exchange2(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while(left < right){
               if (nums[left] % 2 != 0){
                   left++;
                   continue;
               }
               if (nums[right] % 2 == 0){
                   right--;
                   continue;
               }
               // 交换位置
               int temp = nums[left];
               nums[left] = nums[right];
               nums[right] = temp;
            }
            return nums;
        }
    }
}
