package com.siven.datastruct;

/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 解题关键：输入一个递增排序的数组的一个旋转
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Sample4 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int nums[] = {1,1};
        System.out.println(minArray2(nums) + "耗时：" + (System.currentTimeMillis() - start));

    }

    static public int minArray(int[] numbers) {
        int result = -1;
        // 排序
        if (numbers.length > 0) {
            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    int value = numbers[i];
                    int value2 = numbers[j];
                    if (value > value2) {
                        numbers[i] = value2;
                        numbers[j] = value;
                        continue;
                    }
                }
            }
            result = numbers[0];
        }
        return result;
    }

    // 解题关键：输入一个递增排序的数组的一个旋转
    static public int minArray2(int[] numbers) {
        int result = -1;
        if (numbers.length == 1) {
            result = numbers[0];
        }else {
            // 获取旋转点
            int index = numbers.length / 2;
            int startRight = index + 1; // 右边起始点
            if (numbers[startRight] < numbers[index]) {
                result = numbers[startRight];
            }else{
                result = numbers[index-1];
            }
        }

        return result;
    }
}
