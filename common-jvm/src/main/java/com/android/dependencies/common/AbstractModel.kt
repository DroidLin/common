package com.android.dependencies.common

abstract class AbstractModel : Comparable, INoProguard {

    override fun areItemTheSame(item: Any?): Boolean {
        return item != null && this.javaClass == item.javaClass
    }

    override fun areContentTheSame(item: Any?): Boolean = false
}