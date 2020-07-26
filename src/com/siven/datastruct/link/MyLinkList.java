package com.siven.datastruct.link;

import com.siven.datastruct.models.Node;

/**
 * author siven
 * date: 2020/7/18
 * desc: 自己实现线性表的单链表存储结构
 **/
public class MyLinkList<E> {
    public static void main(String[] args) {
        MyLinkList<String> linkList = new MyLinkList<>();
        linkList.add("1");
        linkList.add("2");
        linkList.add("3");
        linkList.testLog();
        //  测试指定位置添加
//        linkList.add(7, "4");
//        linkList.testLog();
        // 测试指定位置删除
//        linkList.remove(0);
        linkList.remove("3");
        linkList.testLog();
        linkList.removeAll();
        linkList.testLog();
        linkList.add("frist");
        linkList.testLog();
    }

    // 链表长度
    private volatile int linkLength;
    // 头结点
    private Node<E> headNode;
    // 尾节点
    private Node<E> lastNode;

    public MyLinkList() {

    }

    /**
     * add，默认实现尾插入
     *
     * @param obj
     */
    public void add(E obj) {
        Node<E> node = getNode(obj);
        Node<E> beforLas = lastNode;
        lastNode = node;
        if (headNode == null) {
            // 头结点是空，则将当前这个作为头结点，无上个指针引用
            headNode = node;
        } else {
            // 将上一次的为节点引用更新
            beforLas.setNext(node);
        }
        // 长度+1
        linkLength++;
    }

    public void add(int index, E obj) {
        Node<E> node = getNode(obj);
        if (index >= linkLength || headNode == null) {
            // 如果长度越界，则插入到尾部
            add(obj);
            return;
        }
        Node<E> targetNodeBefor = headNode;
        // 查找目标的上一个节点
        for (int i = 0; i < index - 1; i++) {
            targetNodeBefor = targetNodeBefor.getNext();
        }
        Node targetNode = targetNodeBefor.getNext();
        // 更新引用
        targetNodeBefor.setNext(node);
        node.setNext(targetNode);
        // 长度+1
        linkLength++;
    }

    public void remove(int index) {
        if (index < 0 || index >= linkLength) {
            throw new IllegalStateException(String.format("remove index:%s, length:%s", index, linkLength));
        }
        Node<E> targetNodeBefor = headNode;
        Node targetNode = null;
        // 目标位置的前驱节点
        int beforIndex = index - 1;
        if (beforIndex < 0) {
            headNode = headNode.getNext();
        } else {
            // 查找目标的前驱节点
            for (int i = 0; i < beforIndex; i++) {
                targetNodeBefor = targetNodeBefor.getNext();
            }
            targetNode = targetNodeBefor.getNext();
            targetNode.setNext(null); // 删除引用
            // 更新引用
            targetNodeBefor.setNext(targetNode.getNext());
        }
        if (index == linkLength - 1) {
            // 更新尾节点
            lastNode = targetNode;
        }
        // 长度-1
        linkLength--;
    }

    public void remove(E obj) {
        Node<E> targetNode = headNode;
        int targetIndex = 0;
        // 移除通过eq来判断
        for (int i = 0; i < linkLength; i++) {
            if (obj.equals(targetNode.getValue())) {
                break;
            }
            targetNode = targetNode.getNext();
            targetIndex++;
        }
        if (targetNode != null) {
            // 更新引用
            remove(targetIndex);
        }
    }

    public void removeAll() {
        Node node = headNode;
        while (node != null) {
            node = node.getNext();
            // 删除引用
            if (node != null) {
                node.setNext(null);
            }
        }
        headNode = null;
        linkLength = 0;
    }

    private void testLog() {
        StringBuilder log = new StringBuilder();
        Node node = headNode;
        log.append("[");
        while (node != null) {
            log.append(node.getValue());
            node = node.getNext();
            if(node != null){
                log.append(",");
            }
        }
        log.append("]");
        System.out.println(log + " , size:" + linkLength);
    }

    /**
     * 获取节点，不设置next
     *
     * @param obj
     * @return
     */
    private Node<E> getNode(E obj) {
        Node<E> node = new Node<>();
        node.setValue(obj);
        return node;
    }
}
