package com.android.dependencies.common.android

import android.content.Context
import com.android.dependencies.common.ComponentFacade

/**
 * @author liuzhongao
 * @since 2024/4/12 20:45
 */

fun installContext(context: Context) {
    ContextImpl.attachApplicationContext(context)
}