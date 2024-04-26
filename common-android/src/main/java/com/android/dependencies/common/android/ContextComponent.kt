package com.android.dependencies.common.android

import com.android.dependencies.common.Component
import com.android.dependencies.common.ComponentInstaller

/**
 * @author liuzhongao
 * @since 2024/4/1 23:22
 */
class ContextComponent : Component {

    override val name: String get() = "ContextComponent"

    override fun collect(installer: ComponentInstaller) {
        installer.installLazily(IContext::class.java) { ContextImpl }
    }
}