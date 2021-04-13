package com.siven.datastruct.utils

import java.lang.StringBuilder

fun IntArray.string(): String {
    var stringBuilder = StringBuilder()
    forEach {
        stringBuilder.append(it)
    }
    return stringBuilder.toString()
}