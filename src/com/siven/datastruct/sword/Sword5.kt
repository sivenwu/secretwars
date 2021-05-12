package com.siven.datastruct.sword

import java.lang.StringBuilder

//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
object Sword5 {
    @JvmStatic
    fun main(args: Array<String>) {
        var s = "We are happy."
        print(replaceSpace(s))
    }

    fun replaceSpace(s: String): String {
        var result = StringBuilder()
        for (c in s.toCharArray()){
            if(c == ' '){
                result.append("%20")
                continue
            }
            result.append(c)
        }
        return result.toString()
    }
}
