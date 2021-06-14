package com.siven.datastruct.sword;

import com.siven.datastruct.sword.bean.TreeNode;

/**
 * create time : 2021/6/14
 * coding : siven
 * description :
 * <p>
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * 3
 * / \
 * 4  5
 * / \
 * 1  2
 * 给定的树 B：
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * 示例 1：
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword26 {

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.right.right = new TreeNode(4);
        TreeNode B = null;

        System.out.println(new Sword26().isSubStructure(A, B));
    }

    // 自己的思路只判断的两个树完全相等
//    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        if (B == null || A == null){
//            return false;
//        }
//        return (recTreeNode(A.left, B.left) && recTreeNode(A.right, B.right));
//    }
//
//    public boolean recTreeNode(TreeNode A, TreeNode B) {
//        if (A == null) {
//            return false;
//        }
//        if (B == null) {
//            return true;
//        }
//        return A.val == B.val;
//    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        if (A == null && B == null) {
            return true;
        }
        return recIsSubStructure(A, B);
    }

    public boolean recIsSubStructure(TreeNode A, TreeNode B) {
        if (A != null && B == null) {
            return true;
        }
        if (A == null && B != null) {
            return false;
        }
        // 只有三种情况
        // 1. A、B树两个都完全相等
        // 2. B是A的左子树其中一个环节，终止条件如果B为空，说明遍历完成是true,否则如果是A空，说明A的节点少于B，结果则为false
        // 3. B是B的右子树其中一个环节，终止条件如果B为空，说明遍历完成是true,否则如果是A空，说明A的节点少于B，结果则为false
        return recIsSubStructure(A.left, B) || recIsSubStructure(A.right, B) || eqTreeNode(A, B);
    }

    public boolean eqTreeNode(TreeNode A, TreeNode B) {
        if (A == null && B != null) {
            return false;
        }
        if (B == null) {
            return true;
        }
        if (A.val != B.val){
            return false;
        }
        return eqTreeNode(A.left, B.left) && eqTreeNode(A.right, B.right);
    }
}
