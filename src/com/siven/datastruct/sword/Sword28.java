package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;
import com.siven.datastruct.sword.util.Log;

/**
 * create time : 2021/6/15
 * coding : siven
 * description : 对称二叉树
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 * 1
 * / \
 * 2  2
 * / \ / \
 * 3 4 4 3
 * <p>
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 * 1
 * / \
 * 2  2
 * \  \
 * 3  3
 * <p>
 * <p>
 * 示例 1：
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword28 {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            return recuAction(root.left, root.right);
        }

        public boolean recuAction(TreeNode left, TreeNode right) {
            // 这里终止条件要思考下：
            // 都是null就人为是支持了
            if(left == null && right == null){
                return true;
            }
            // 题目说了其中一个是null的话不算
            if (left == null || right == null){
                return false;
            }
            return left.val == right.val && recuAction(left.left,right.right) && recuAction(left.right,right.left);
        }
    }

}
