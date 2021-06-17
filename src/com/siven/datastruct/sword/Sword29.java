package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;

/**
 * create time : 2021/6/15
 * coding : siven
 * description : 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword29 {

    public static void main(String[] args) {

    }

    static class Solution {
        /**
         * 因为就四种走法，所以定义一个上up下down左left右right的边界，定义一个当前的坐标(x,y)，定义一个结果数组result,定义一个当前结果数组存到了第几位置posi：
         * <p>
         * 1.左->右:result[posi++] = matrix[x][y++]
         * 2.上->下:result[posi++] = matrix[x++][y]
         * 3.右->左:result[posi++] = matrix[x][y--]
         * 4.下->上:result[posi++] = matrix[x--][y]
         * 上面四种情况while里面跑完记得更新下边界还有(x,y)坐标使得下一阶段起始时坐标是对的
         * 返回结果result
         *
         * @param matrix
         * @return
         */
        public int[] spiralOrder(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            if (n == 0 || m == 0){
                // 防止传了空数组
                return new int[0];
            }
            int[] result = new int[m * n];
            // 定义四个方向边界
            int up = 0;
            int down = m - 1;
            int left = 0;
            int right = n - 1;
            // 当前结果数据的位置
            int posi = 0;
            // 当前坐标
            int x = 0;
            int y = 0;
            while (posi < m * n) {
                // 左 -> 右
                while (posi < m * n && y <= right) {
                    result[posi++] = matrix[x][y++];
                }
                //更新当前坐标
                up++;
                x = up;
                y = right;
                // 上 -> 下
                while (posi < m * n && x <= down) {
                    result[posi++] = matrix[x++][y];
                }
                //更新当前坐标
                right--;
                x = down;
                y = right;
                // 右 -> 左
                while (posi < m * n && y>=left){
                    result[posi++] = matrix[x][y--];
                }
                //更新当前坐标
                down--;
                x = down;
                y = left;
                // 下 -> 上
                while (posi < m * n && x>=up){
                    result[posi++] = matrix[x--][y];
                }
                //更新当前坐标
                left++;
                x = up;
                y = left;
            }
            return result;
        }
    }

}
