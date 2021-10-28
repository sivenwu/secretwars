package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * create time : 2021/6/18
 * coding : siven
 * description : 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword33 {

    public static void main(String[] args) {

    }

    /**
     * 二叉搜索树定义：
     * 左子树中所有节点的值 < 根节点的值；
     * 右子树中所有节点的值 > 根节点的值；其左、右子树也分别为二叉搜索树
     * 最后是根节点
     */
    class Solution {
        // 1. 递归分治
        public boolean verifyPostorder(int[] postorder) {
            return recuAction(postorder, 0, postorder.length - 1);
        }

        /**
         * 递归分治
         *
         * @param postorder 表示后序遍历结果集
         * @param i         i表示起始节点
         * @param j         j表示结束节点
         * @return
         */
        public boolean recuAction(int[] postorder, int i, int j) {
            // 如果遍历节点已经没有，表示这个区间已经完成遍历
            if (i <= j) return true;
            int p = i;
            // 第一个大于根节点 的节点m
            while (postorder[p] < postorder[j]) p++;
            int m = p; // 则区间是[0,m-1][m,j-1]
            // 右子树区间 [m, j-1]内的所有节点都应 > postorder[j]
            // 如果一直循环支持都满足postorder[p] > postorder[j]，此时P==J的话，说明二叉树右子树是成立的！
            while (postorder[p] > postorder[j]) p++;
            return p == j && recuAction(postorder, 0, m - 1) && recuAction(postorder, m, j - 1);
        }
    }
}
