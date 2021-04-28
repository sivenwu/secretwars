package com.siven.datastruct.swordoffer;

/**
 * author siven
 * date: 2020/7/26
 * desc:
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Offer13_ {

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(2,3,1));
    }

    public static class Solution {
        public int movingCount(int m, int n, int k) {
            boolean visited[][] = new boolean[m][n];
            int start = 0;
            for (int i = 0;i<visited.length;i++){
                for (int j = 0;j<visited[0].length;j++){
                    if (gotoAction(i,j,k,visited,start)){
                        return cursor;
                    }
                }
            }
            return cursor;
        }

        // 终止条件:
        int cursor = 0;
        private boolean gotoAction(int i, int j, int k, boolean visited[][], int start) {
            if (i < 0 || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j]){
                return false;
            }
            int sum =0;
            int tmp = Integer.parseInt(i+""+j);
            sum = numberSum(tmp);

            if (sum <= 0 || sum > k) {
                return false;
            }

            if (i == visited.length - 2 && j == visited[0].length-2) {
                cursor++;
                return true;
            }

            visited[i][j] = true;
            boolean result = gotoAction(i + 1, j, k, visited, start + 1)
                    || gotoAction(i, j + 1, k, visited, start + 1)
                    || gotoAction(i - 1, j, k, visited, start + 1)
                    || gotoAction(i, j - 1, k, visited, start + 1);
            visited[i][j] = false;
            if (result){
                cursor++;
            }
            return result;
        }

    }

    public static int numberSum(int a){
        int n = a%10;
        a = a-n;
        int m = a/10;
        int sum=0;
        sum = sum+n;

        while(m!=0)
        {
            sum = sum+m%10;
            m=m/10;
        }
        return sum;
    }

}
