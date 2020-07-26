package com.siven.datastruct.stack;

import com.siven.datastruct.models.Node;

/**
 * author siven
 * date: 2020/7/26
 * desc: 实现栈的功能，后进先出，链表存储结构（案例使用单链表实现,所以出栈要遍历更新栈顶指针，双向链表则不用）,永远不会越界
 **/
public class MyStack2 implements IStack {

    // 栈底
    private Node endNode;
    // 栈顶
    private Node topNode;
    // 栈大小
    private int stackSize;

    @Override
    public void clear() {
        endNode.setNext(null);
        endNode = null;
        topNode = null;
        stackSize = 0;
    }

    @Override
    public void push(Object data) {
        Node node = getNode(data);
        if (topNode == null) {
            // 直接是head指针
            topNode = node;
            endNode = node;
        } else {
            topNode.setNext(node);
            // 更新栈顶位置
            topNode = node;
        }
        stackSize++;
    }

    @Override
    public Object pop() {
        if (topNode == null) {
            throw new IllegalStateException("栈已空了..");
        }
        Object object = topNode.getValue();
        // 找到栈顶的前驱节点
        Node node = endNode;
        Node endPreNode = null;
        while (node != topNode) {
            endPreNode = node;
            node = node.getNext();
        }
        if (endPreNode != null) {
            endPreNode.setNext(null);
            topNode = endPreNode;
        } else {
            // 说明到栈底了
            topNode = null;
            endNode = null;
        }

        stackSize--;
        return object;
    }

    @Override
    public int stackSize() {
        return stackSize;
    }

    private Node<Object> getNode(Object obj) {
        Node node = new Node<>();
        node.setValue(obj);
        return node;
    }

    public void testLog() {
        StringBuilder log = new StringBuilder();
        Node node = endNode;
        log.append("栈内容为：[");
        while (node != null) {
            log.append(node.getValue());
            node = node.getNext();
            if (node != null) {
                log.append(",");
            }
        }
        log.append("]");
        System.out.println(log + "，栈大小:"+stackSize());
    }
}
