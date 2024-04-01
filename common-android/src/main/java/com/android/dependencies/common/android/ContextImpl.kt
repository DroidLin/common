package com.android.dependencies.common.android

import android.content.Context
import java.lang.ref.WeakReference

/**
 * @author liuzhongao
 * @since 2024/4/1 23:35
 */
internal object ContextImpl : IContext {
    private var _contextRef: WeakReference<Context>? = null

    override val applicationContext: Context
        get() = requireNotNull(this._contextRef?.get())

    fun attachApplicationContext(applicationContext: Context) {
        this._contextRef = WeakReference(applicationContext)
    }
}