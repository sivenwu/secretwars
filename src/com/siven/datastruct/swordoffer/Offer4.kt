package com.siven.datastruct.swordoffer

//一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
//        示例:
//
//        现有矩阵 matrix 如下：
//
//        [
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
//        ]
//        给定 target = 5，返回 true。
//
//        给定 target = 20，返回 false。
//
//        限制：
//        0 <= n <= 1000
//        0 <= m <= 1000
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
object Offer4 {
    @JvmStatic
    fun main(args: Array<String>) {
        var martrix: Array<IntArray> = arrayOf<IntArray>(
                intArrayOf(1, 4, 7, 11, 15),
                intArrayOf(2, 5, 8, 12, 19),
                intArrayOf(3, 6, 9, 16, 22),
                intArrayOf(10, 13, 14, 17, 24),
                intArrayOf(18, 21, 23, 26, 30))
        System.out.println(findNumberIn2DArray2(martrix, 41))
    }

    /**
     * 解题思路：
     * 1. 一开始思路是接近的，从左上角开始看相邻两个元素，分别判断大小在决定游标行+1或者列+1
     * 2. 但是因为如果从左上角，因为都是递增顺序，所以存在相邻两个元素都同样满足大于或满足小于，不互斥！！
     * 3. 最后想到从选择一个互斥的方向，即右上角的元素！左边是递减、右边是递增，所以一定是互斥的
     */
    fun findNumberIn2DArray2(matrix: Array<IntArray>, target: Int): Boolean {
        var result = false
        var cusorRowIndex = 0
        var cusorColumnIndex = matrix[cusorRowIndex].size-1

        var end = false
        while (!end) {
            var cusorValue = matrix[cusorRowIndex][cusorColumnIndex]
            if (cusorValue == target){
                result = true
            }

            if (target > cusorValue){
                cusorRowIndex++
            }
            if (target<cusorValue){
                cusorColumnIndex--
            }

            end =  result || (cusorColumnIndex <0) || (cusorRowIndex >= matrix.size)
        }

        return result
    }

    fun findNumberIn2DArray(matrix: Array<IntArray>, target: Int): Boolean {
        var result = false
        var cusorRowIndex = 0
        var cusorColumnIndex = 0

        var end = false
        while (!end) {
            var hasRowValue = (cusorRowIndex + 1 < matrix.size)
            var hasColumnValue = (cusorColumnIndex + 1 < matrix[cusorRowIndex + 1].size)
            end = !hasColumnValue && !hasRowValue
            if (!end) {
                var tmp1 = 0
                var tmp2 = 0
                var cusorVaule = matrix[cusorRowIndex][cusorColumnIndex]
                if (hasColumnValue)
                    tmp1 = matrix[cusorRowIndex][cusorColumnIndex + 1]
                if (hasRowValue)
                    tmp2 = matrix[cusorRowIndex + 1][cusorColumnIndex]
                if (tmp1 == target || tmp2 == target || cusorVaule == target) {
                    result = true
                    end = true
                }
                if (tmp1 > tmp2 && target > tmp1) {
                    cusorColumnIndex++
                }

                if (tmp2 > tmp1 && target > tmp2) {
                    cusorRowIndex++
                }
            }
        }

        return result
    }
}
