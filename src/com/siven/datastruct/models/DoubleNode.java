package com.siven.datastruct.models;

/**
 * author siven
 * date: 2020/7/18
 * desc: 简单封装单链表节点
 **/
public class DoubleNode<T> {
    private T value; // 值
    private DoubleNode<T> next; // 下一个节点的引用
    private DoubleNode<T> befor; // 一上个节点的引用

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> getBefor() {
        return befor;
    }

    public void setBefor(DoubleNode<T> befor) {
        this.befor = befor;
    }
}
