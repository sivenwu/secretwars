package com.siven.datastruct.queue;

import com.siven.datastruct.models.Node;
import com.siven.datastruct.utils.NodeTool;

/**
 * author siven
 * date: 2020/7/26
 * desc: 链式存储结构实现队列，循环队列
 **/
public class MyQueue2 implements IQueue {

    private int queueSize;
    // node
    private Node<Object> topNode; // 队头指针
    private Node<Object> endNode; // 队尾指针

    public MyQueue2() {
        this.init();
    }

    private void init() {

    }

    @Override
    public void enQueue(Object object) {
        Node node = NodeTool.getNode(object);
        if (endNode == null) {
            endNode = node;
            topNode = node;
            topNode.setNext(endNode);
            queueSize++;
            return;
        }

        endNode.setNext(node);
        endNode = node;
        queueSize++;
    }

    @Override
    public Object deQueue() {
        if (topNode == null) {
            throw new IllegalStateException("队列已空..");
        }
        Object object = topNode.getValue();
        topNode = topNode.getNext();
        queueSize--;
        return object;
    }

    @Override
    public void clear() {
        Node node = topNode;
        while (node.getNext() != null) {
            Node nodeTmp = node.getNext();
            node.setNext(null);
            node = nodeTmp;
        }
        topNode.setNext(null);
        topNode = null;
        endNode = null;
        queueSize = 0;
    }

    @Override
    public int queueSize() {
        return queueSize;
    }

    public void testLog() {
        StringBuilder log = new StringBuilder();
        Node node = topNode;
        log.append("[");
        while (node != null) {
            log.append(node.getValue().toString());
            node = node.getNext();
            if (node != null) {
                log.append(",");
            }
        }
        log.append("]");
        System.out.println(log + "，队列大小:" + queueSize());
    }
}
