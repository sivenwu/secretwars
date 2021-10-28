package com.siven.datastruct.sword;

/**
 * create time : 2021/8/9
 * coding : siven
 * description : 剑指 Offer 47. 礼物的最大价值
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword47 {

    public static void main(String[] args) {
//        [[1,3,1],[1,5,1],[4,2,1]]
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        new Solution().maxValue(grid);
    }

    static class Solution {
        int result = 0;

        /**
         * 状态方程式推演
         * -背景 如果长度为m,n,则礼物最大价值为f(m-1,n-1) 为终止条件
         * -案例 f(2,2)最大价值为 f(2,2) = max(f(2,1),f(1,2)) + f(2,2)
         * -推演：
         * 状态工程式 f(i,j) = max(f(i,j-1),f(i-1,j)) + grid[i][j]
         */
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i - 1][j - 1];
                }
            }
            return dp[m-1][n-1];
        }

    }
}
