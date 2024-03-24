package com.android.dependencies.common

interface Component {

    val name: String

    fun collect(installer: ComponentInstaller)

    fun interface Factory<T : Any> {

        fun componentCreate(): T
    }
}