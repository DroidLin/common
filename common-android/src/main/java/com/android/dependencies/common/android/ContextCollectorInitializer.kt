package com.android.dependencies.common.android

import android.content.Context
import androidx.startup.Initializer

/**
 * @author liuzhongao
 * @since 2024/4/1 23:28
 */
class ContextCollectorInitializer : Initializer<IContext> {

    override fun create(context: Context): IContext {
        ContextImpl.attachApplicationContext(context.applicationContext)
        return ContextImpl
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}