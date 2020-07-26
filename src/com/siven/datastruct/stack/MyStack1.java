package com.siven.datastruct.stack;

import com.siven.datastruct.models.Node;

/**
 * author siven
 * date: 2020/7/26
 * desc: 实现栈的功能，后进先出，线性表存储结构
 **/
public class MyStack1 implements IStack {

    private final int MAX_SIZE_DEF = 10;

    private Object[] arrays;

    private int topIndex = -1; // 头指针，默认在第0个指标
    private int initSize;

    public MyStack1() {
        init(MAX_SIZE_DEF);
    }

    public MyStack1(int stackSize) {
        init(stackSize);
    }

    private void init(int size) {
        initSize = size;
        arrays = new Object[initSize];
    }

    @Override
    public void clear() {
        topIndex = -1;
        arrays = null;
        init(initSize);
    }

    @Override
    public void push(Object data) {
        if (topIndex == initSize - 1) {
            throw new IllegalStateException("越界了..");
        }
        topIndex++;
        arrays[topIndex] = data;
    }

    @Override
    public Object pop() {
        if (topIndex < 0) {
            throw new IllegalStateException("栈已空了..");
        }
        Object data = arrays[topIndex];
        arrays[topIndex] = null;
        topIndex--;
        return data;
    }

    @Override
    public int stackSize() {
        return topIndex + 1;
    }

    public void testLog() {
        StringBuilder log = new StringBuilder();
        log.append("栈内容为：[");
        for (int i = 0; i < arrays.length; i++) {
            Object object = arrays[i];
            if (object != null) {
                if(i > 0){
                    log.append(",");
                }
                log.append(object.toString());
            }
        }
        log.append("]");
        System.out.println(log + "，栈大小:" + stackSize());
    }

}
