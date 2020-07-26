package com.siven.datastruct.models;

/**
 * author siven
 * date: 2020/7/18
 * desc: 简单封装单链表节点
 **/
public class Node<T> {
    private T value; // 值
    private Node<T> next; // 下一个节点的引用

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

}
