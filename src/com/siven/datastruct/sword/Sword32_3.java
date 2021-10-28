package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * create time : 2021/6/18
 * coding : siven
 * description : 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword32_3 {

    public static void main(String[] args) {

    }

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        List<List<Integer>> result = new ArrayList<>();
        public List<List<Integer>> levelOrder(TreeNode root) {
            recuAction(root, 0);
            return result;
        }

        /**
         * @param node 当前节点
         * @param k    表示当前层
         */
        private void recuAction(TreeNode node, int k) {
            if (node == null){
                // node为空的时候就终止
                return;
            }
            if (result.size() <= k){
                result.add(k, new ArrayList<>());
            }
            result.get(k).add(node.val);
            if (!(k == 0 || k % 2 ==0)) {
                // 开始遍历下一层
                recuAction(node.left, k + 1);
                recuAction(node.right, k + 1);
            }else{
                recuAction(node.right, k + 1);
                recuAction(node.left, k + 1);
            }
        }
    }
}
