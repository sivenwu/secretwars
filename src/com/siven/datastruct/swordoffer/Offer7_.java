package com.siven.datastruct.swordoffer;

import com.siven.datastruct.tree.model.TreeNode;

import java.util.Arrays;

/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如：
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 **/
public class Offer7_ {

    public static void main(String[] args) {
        int preorder[] = {1, 2, 3};
        int inorder[] = {1, 3, 2};
        System.out.println(buildTree2(preorder, inorder));
    }

    /**
     * 思路：
     * 1. 前序遍历可以分析 head节点、左子树
     * 2. 中序遍历可以分析 左子树的首节点、右子树尾节点
     * <p>
     * 模拟下构建树思路：
     * 背景：结果中都不含重复的数字
     * 1. 通过前序遍历得知 head=3
     * 2. 继续遍历preorder的9，判断是否在inorder中第一个出现，是9，则说明是当前父亲的左子树，当前节点的父亲不用更新
     * 3. 继续遍历preorder的20，判断是否在inorder中第一个出现，则说明是9的左子树，是3，不相等否则为9父亲的右子树
     * 4. 继续遍历preorder的15，判断是否在inorder中第一个出现，是15，说明是20的左子树
     * 5. 继续遍历preorder的7,判断是否在inorder中第一个出现，是20，说明是15父亲的右子树
     *
     * @param preorder
     * @param inorder
     * @return 错误思路
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode headNode = new TreeNode(preorder[0]);
        TreeNode beforNode = headNode;
        for (int i = 1; i < preorder.length; i++) {
            int value = preorder[i];
            TreeNode node = beforNode;
            TreeNode curNode = new TreeNode(value);
            if (value == inorder[i - 1]) {
                // 说明是该节点的左子树
                node.leftNode = curNode;
                // 父节点还是node,不用变更
            } else {
                // 说明是该节点父亲的右子树
                node.rightNode = curNode;
                beforNode = curNode;
            }
        }

        return headNode;
    }

    /**
     * 二叉树知识点：
     * <p>
     * 前序遍历列表：第一个元素永远是 【根节点 (root)】
     * 中序遍历列表：根节点 (root)【左边】的所有元素都在根节点的【左分支】，【右边】的所有元素都在根节点的【右分支】
     * 例如：
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode buildTree2(int[] preorder, int[] inorder) {
        int n = preorder.length;
        if (n == 0)
            return null;
        int rootVal = preorder[0], inRootIndex = 0;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == rootVal) {
                // 找中序遍历中根节点的位置
                inRootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        // 中序遍历中，根节点左边的所有元素都在根节点左分支
        // 所以这里前序范围为1~inRootIndex(中序遍历中根节点的位置),中序则是中序遍历的左边，即0-inRootIndex
        root.leftNode = buildTree(Arrays.copyOfRange(preorder, 1, 1 + inRootIndex), Arrays.copyOfRange(inorder, 0, inRootIndex));
        // 中序遍历中，根节点右边的所有元素都在根节点右分支
        // 所以这里前序范围为inRootIndex+1~n(最后一个节点),中序则是中序遍历的右边，即inRootIndex+1~n
        root.rightNode = buildTree(Arrays.copyOfRange(preorder, 1 + inRootIndex, n), Arrays.copyOfRange(inorder, inRootIndex + 1, n));
        return root;
    }
}
