package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;
import com.siven.datastruct.sword.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * create time : 2021/6/18
 * coding : siven
 * description : 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword34 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(11);
        treeNode.left.left.left = new TreeNode(7);
        treeNode.left.left.right = new TreeNode(2);
        treeNode.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(13);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.right.left = new TreeNode(5);
        treeNode.right.right.right = new TreeNode(1);
        List<List<Integer>> result = new Solution().pathSum(treeNode, 22);
        Log.i(result.toString());
    }

    static class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> pathSum(TreeNode root, int target) {
            recuAction(root, target);
            return result;
        }

        /**
         * *               5
         * *              / \
         * *             4   8
         * *            /   / \
         * *           11  13  4
         * *          /  \    / \
         * *         7    2  5   1
         * *
         * target 22
         * *
         */
        private List<Integer> path = new ArrayList<>();

        private void recuAction(TreeNode node, int sum) {
            if (node == null) {
                return;
            }
            path.add(node.val);
            sum = sum - node.val;
            if (sum == 0) {
                result.add(new ArrayList<>(path));
            } else {
                recuAction(node.left, sum);
                recuAction(node.right, sum);
            }
            //这个是关键，做回溯！
            path.remove(path.size() - 1);
        }
    }
}
