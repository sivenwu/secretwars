package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;
import com.siven.datastruct.sword.util.Log;

/**
 * create time : 2021/6/15
 * coding : siven
 * description : 二叉树的镜像
 *
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * 例如输入：
 *   4
 *  /  \
 *  2   7
 * / \  / \
 * 1  3 6  9
 *
 * 镜像输出：
 *   4
 *  /  \
 *  7   2
 * / \  / \
 * 9  6 3 1
 *
 * 示例 1：
 * 输入：root = [4,2,7,1,3,6,9]
 * 输出：[4,7,2,9,6,3,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword27 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root = Solution.mirrorTree(root);
        Log.i(root.toString());
    }

    static class Solution {
        // 能通过，效率比较慢
        public static TreeNode mirrorTree(TreeNode root) {
            if (root != null){
                TreeNode leftNode = root.left;
                TreeNode rightNode = root.right;
                root.right = mirrorTree(leftNode);
                root.left = mirrorTree(rightNode);
            }
            return root;
        }

        // 栈或者队列
        // 利用栈（或队列）遍历树的所有节点 nodenode ，并交换每个 nodenode 的左 / 右子节点
//        public TreeNode mirrorTree(TreeNode root) {
//            if(root == null) return null;
//            Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
//            while(!stack.isEmpty()) {
//                TreeNode node = stack.pop();
//                if(node.left != null) stack.add(node.left);
//                if(node.right != null) stack.add(node.right);
//                TreeNode tmp = node.left;
//                node.left = node.right;
//                node.right = tmp;
//            }
//            return root;
//        }
    }

}
