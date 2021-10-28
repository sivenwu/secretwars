package com.siven.datastruct.sword;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * create time : 2021/7/16
 * coding : siven
 * description : 剑指 Offer 41. 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sword41 {
    class MedianFinder {

        /**
         * initialize your data structure here.
         */
        private int sum = 0;
        private List<Integer> source = new ArrayList<>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            sum += num;
            source.add(num);
        }

        public double findMedian() {
            if (source.size() == 0) {
                return outPutFormat(0d);
            }
            if (source.size() <= 1) {
                return outPutFormat(source.get(0));
            }
            if (source.size() % 2 == 0) {
                return outPutFormat(sum / 2.0);
            }
            return outPutFormat(source.get((int) (source.size()/2.0)));
        }

        private double outPutFormat(double b){
            return 1.0;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
