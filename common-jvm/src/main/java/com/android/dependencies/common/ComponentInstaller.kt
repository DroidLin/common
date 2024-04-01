package com.android.dependencies.common

interface ComponentInstaller {

    fun <T : Any> install(clazz: Class<T>, implementation: T)

    fun <T : Any> installLazily(clazz: Class<T>, componentFactory: Component.Factory<T>)

    companion object : ComponentInstaller {
        override fun <T : Any> install(clazz: Class<T>, implementation: T) {
            ComponentFacade[clazz] = implementation
        }
        override fun <T : Any> installLazily(clazz: Class<T>, componentFactory: Component.Factory<T>) {
            ComponentFacade[clazz] = componentFactory
        }
    }
}