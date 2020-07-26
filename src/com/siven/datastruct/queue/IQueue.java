package com.siven.datastruct.queue;

/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 **/
public interface IQueue {

    /**
     * 入队
     * @param object
     */
    void enQueue(Object object);

    /**
     * 出队
     * @return
     */
    Object deQueue();

    /**
     * 清空队列
     */
    void clear();

    /**
     * 队列大小
     * @return
     */
    int queueSize();
}
