package com.android.dependencies.common.android

import android.content.Context
import com.android.dependencies.common.ComponentFacade

/**
 * @author liuzhongao
 * @since 2024/4/12 20:45
 */

fun ComponentFacade.initContext(context: Context) {
    (this[IContext::class.java] as? ContextImpl)?.attachApplicationContext(context)
}