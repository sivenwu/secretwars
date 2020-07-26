package com.siven.datastruct.queue;

/**
 * author siven
 * date: 2020/7/26
 * desc: 线性存储结构实现队列，循环队列
 **/
public class MyQueue1 implements IQueue {

    // 初始化大小，默认是10
    private int initSize = 5;

    private Object[] arrays;
    private int topIndex; // 队头
    private int endIndex; // 队尾
    private int queueSize;

    public MyQueue1(int initSize) {
        this.initSize = initSize;
        this.init();
    }

    public MyQueue1() {
        this.init();
    }

    private void init() {
        arrays = new Object[initSize];
    }

    @Override
    public void enQueue(Object object) {
        if (endIndex == 0) {
            arrays[endIndex] = object;
            endIndex++;
            queueSize++;
            return;
        }
        int readEndIndex = endIndex;
        if (readEndIndex < initSize && arrays[readEndIndex] == null) {
            arrays[readEndIndex] = object;
            endIndex++;
            queueSize++;
        } else if (topIndex > 0 && (arrays[topIndex - 1]) == null) {
            //  可以插入的其他空白区间，达到循环队列的要求
            endIndex = 0;
            arrays[endIndex] = object;
            endIndex++;
            queueSize++;
        } else {
            throw new IllegalStateException("队列满了..");
        }
    }

    @Override
    public Object deQueue() {
        Object object = arrays[topIndex];
        arrays[topIndex] = null;
        topIndex++;
        if (topIndex > initSize - 1) {
            topIndex = 0;
        }
        queueSize--;
        return object;
    }

    @Override
    public void clear() {

    }

    @Override
    public int queueSize() {
        return queueSize;
    }

    public void testLog() {
        StringBuilder log = new StringBuilder();
        log.append("队列内容为：[");
        for (int i = 0; i < arrays.length; i++) {
            Object object = arrays[i];
            if (object != null) {
                log.append(object.toString());
            }else{
                log.append("null");
            }
            if(i < arrays.length-1) {
                log.append(",");
            }
        }
        log.append("]");
        System.out.println(log + "，队列大小:" + queueSize());
    }
}
