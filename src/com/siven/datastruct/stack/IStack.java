package com.siven.datastruct.stack;

public interface IStack {
    /**
     * 清空栈
     */
    void clear();

    /**
     * 入栈
     */
    void push(Object data);

    /**
     * 出栈
     */
    Object pop();

    /**
     * 栈大小
     * @return
     */
    int stackSize();
}
