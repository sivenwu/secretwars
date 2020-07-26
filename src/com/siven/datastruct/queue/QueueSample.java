package com.siven.datastruct.queue;

/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 **/
public class QueueSample {

    public static void main(String[] args) {
        System.out.println("* 线性结构队列实现：");
        MyQueue1 queue1 = new MyQueue1();
        queue1.enQueue("1");
        queue1.enQueue("2");
        queue1.enQueue("3");
        queue1.enQueue("4");
        queue1.enQueue("5");
//        queue1.enQueue("6");// 队列满了
        queue1.testLog();
        Object object = queue1.deQueue();
        System.out.println("出队列: "+object.toString());
        object = queue1.deQueue();
        System.out.println("出队列: "+object.toString());
        queue1.testLog();
        System.out.println("测试循环队列，准备入队6、7...");
        queue1.enQueue("6");
        queue1.enQueue("7");
        queue1.testLog();
        object = queue1.deQueue();
        System.out.println("出队列: "+object.toString());
        object = queue1.deQueue();
        System.out.println("出队列: "+object.toString());
        queue1.testLog();
        System.out.println("测试循环队列，准备入队8...");
        queue1.enQueue("8");
        queue1.testLog();
        object = queue1.deQueue();
        System.out.println("出队列: "+object.toString());
        queue1.testLog();

        System.out.println("\n* 链式结构队列实现：");
        MyQueue2 myQueue2 = new MyQueue2();
        myQueue2.enQueue("1");
        myQueue2.enQueue("2");
        myQueue2.enQueue("3");
        myQueue2.enQueue("4");
        myQueue2.enQueue("5");
//        myQueue2.enQueue("6");// 队列满了
        myQueue2.testLog();
        object = myQueue2.deQueue();
        System.out.println("出队列: "+object.toString());
        object = myQueue2.deQueue();
        System.out.println("出队列: "+object.toString());
        myQueue2.testLog();
        System.out.println("测试循环队列，准备入队6、7...");
        myQueue2.enQueue("6");
        myQueue2.enQueue("7");
        myQueue2.testLog();
        object = myQueue2.deQueue();
        System.out.println("出队列: "+object.toString());
        object = myQueue2.deQueue();
        System.out.println("出队列: "+object.toString());
        myQueue2.testLog();
        System.out.println("测试循环队列，准备入队8...");
        myQueue2.enQueue("8");
        myQueue2.testLog();
        object = myQueue2.deQueue();
        System.out.println("出队列: "+object.toString());
        myQueue2.testLog();
    }
}
