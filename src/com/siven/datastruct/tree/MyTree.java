package com.siven.datastruct.tree;

import com.siven.datastruct.tree.model.TreeNode;

/**
 * author siven
 * date: 2020/7/30
 * desc: 顺序存储的二叉树实现
 **/
public class MyTree<T> implements IMyTree<T> {

    // 根节点
    private TreeNode<T> rootNode;

    public MyTree(T[] array) {
        rootNode = createTree(array);
    }

    @Override
    public TreeNode<T> createTree(T[] arrays) {
        return null;
    }

    @Override
    public void preOrder(TreeNode<T> node) {

    }

    @Override
    public void centerOrder(TreeNode<T> node) {

    }

    @Override
    public void afterOrder(TreeNode<T> node) {

    }
}
