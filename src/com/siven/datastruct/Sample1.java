package com.siven.datastruct;
/**
 * author siven
 * date: 2020/7/26
 * desc: 一句话概括
 **/
public class Sample1 {

    public static void main(String[] args) {
        new Demo();
    }

    static class Demo {
        public int onTest() {
            int i = 1;
            try {
                i = 2;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                //i = 3;
            }
            return i;
        }
    }
}
