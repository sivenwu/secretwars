package com.siven.datastruct.stack;

/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 **/
public class Sample {

    public static void main(String[] args) {
        // 线性存储栈实现
        System.out.println("** 线性存储栈实现:");
        MyStack1 myStack1 = new MyStack1();
        myStack1.push("1");
        myStack1.push("2");
//        myStack1.clear();
        myStack1.testLog();
        Object object = myStack1.pop();
        System.out.println("出栈: "+object.toString());
        object = myStack1.pop();
        System.out.println("出栈: "+object.toString());
        myStack1.testLog();

        // 链式存储栈实现
        System.out.println("** 链式存储栈实现:");
        MyStack2 myStack2 = new MyStack2();
        myStack2.push("1");
        myStack2.push("2");
        myStack2.testLog();
//        myStack2.clear();
//        myStack2.testLog();
        object = myStack2.pop();
        System.out.println("出栈: "+object.toString());
        object = myStack2.pop();
        System.out.println("出栈: "+object.toString());
        myStack2.testLog();
    }
}
