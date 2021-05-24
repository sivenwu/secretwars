
package com.siven.datastruct.sword;

/**
 * author siven
 * date: 2020/7/26
 * desc: 这个案例dp的经典，可以在复习,太经典了！！！！！！！！
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **

/**
 * 思考：
 * 1.状态工程式
 * 假设有长度为n的绳子，第一次切割的长度是i,剩下的长度为n-i,则乘积的结果有两个：
 * (1)i*n-i 切完i后不再切，所以只有两段，结果为i*n-i,i的取值范围是1~n-1(题目要求至少切一刀，所以到n-1)
 * (2)i*dp(n-i),切完i后，总长度为n-i，剩下的总长度为n-j继续dp(动态规划)计算下去
 * 结论：状态工程式为：f(n) = max(fn(i),max(i*n-i,i*f(n-i))),边界值i>=2,因为题目限制2 <= n <= 58
 */
public class Sword14_ {

    public static void main(String[] args) {
        System.out.println(new Solution2().cuttingRope2(127));
    }

    public static class Solution {
        /***
         * 动态规划算法
         * @param n
         * @return
         */
        public int cuttingRope(int n) {
            int result[] = new int[n+1];
            // 边界情况
            result[0] = 0;
            result[1] = 0;
            for (int i = 2;i<result.length;i++){
                //为什么要两个循环？
                // 思路：
                // 1. 有上面的状态工程式: f(n) = max(fn(i),max(i*n-i,i*f(n-i)))
                // 2. 由于下一段即可以不切也可以不切，则说明下次n（总长度是一直在变化得，所以他的取值空间可以在1~i-1）,因此需要第二个循环来控制这个n
                for(int j = 1;j<=i-1;j++){
                    result[i] = Math.max(result[i],Math.max(j*(i-j),j*result[i-j]))%1000000007;
                }
            }
            return result[n];
        }

        /***
         * 贪心算法，每次切3
         * @param n
         * @return
         */
        public long cuttingRope2(int n) {
            long sum = 1;
            while (n > 4){
                sum*=3;
                n-=3;
            }
            sum*=n;
            return sum;
        }
    }

    /**
     * 经典取模
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * 提示：快速幂求余
     */
    public static class Solution2 {
        public int cuttingRope(int n) {
            int result[] = new int[n+1];
            // 边界情况
            result[0] = 0;
            result[1] = 0;
            for (int i = 2;i<result.length;i++){
                //为什么要两个循环？
                // 思路：
                // 1. 有上面的状态工程式: f(n) = max(fn(i),max(i*n-i,i*f(n-i)))
                // 2. 由于下一段即可以不切也可以不切，则说明下次n（总长度是一直在变化得，所以他的取值空间可以在1~i-1）,因此需要第二个循环来控制这个n
                for(int j = 1;j<=i-1;j++){
                    result[i] = Math.max(result[i],Math.max(j*(i-j),j*result[i-j]))%1000000007;
                }
            }
            return result[n];
        }

        /***
         * 贪心算法，每次切3
         * @param n
         * @return
         */
        public int cuttingRope2(int n) {
            if(n<=3){
                return n-1;
            }
            long sum = 1;
            while (n > 4){
                sum=sum * 3%1000000007;
                n-=3;
            }
            return (int)(sum*n%1000000007);
        }
    }
}
