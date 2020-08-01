package com.siven.datastruct.tree;

import com.siven.datastruct.tree.model.TreeNode;

/**
 * author siven
 * date: 2020/7/30
 * desc: 二叉树基本操作
 **/
public interface IMyTree<T> {

    /**
     * 二叉树创建,返回根节点
     * @param arrays
     */
    TreeNode<T> createTree(T[] arrays);

    /**
     * 前序遍历
     * @param node
     */
    void preOrder(TreeNode<T> node);

    /**
     * 中序遍历
     */
    void centerOrder(TreeNode<T> node);

    /**
     * 后序遍历
     * @param node
     */
    void afterOrder(TreeNode<T> node);
}
