package com.android.dependencies.common

interface Comparable {

    fun areItemTheSame(item: Any?): Boolean

    fun areContentTheSame(item: Any?): Boolean
}