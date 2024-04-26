package com.android.dependencies.common

import java.util.ServiceLoader

object ComponentFacade {

    private val _componentFactoryMap: MutableMap<Class<*>, Component.Factory<*>> = HashMap()
    private val _componentInstanceMap: MutableMap<Class<*>, Any> = HashMap()

    fun autoInit() {
        val componentList = ServiceLoader.load(Component::class.java).toList()
        componentList.forEach { component: Component? -> component?.collect(ComponentInstaller) }
    }

    fun initComponent(vararg component: Component) {
        component.forEach { it.collect(ComponentInstaller) }
    }

    @JvmStatic
    operator fun <T : Any> set(clazz: Class<T>, implementation: T) {
        synchronized(this._componentInstanceMap) {
            this._componentInstanceMap[clazz] = implementation
        }
    }

    @JvmStatic
    operator fun <T : Any> set(clazz: Class<T>, factory: Component.Factory<T>) {
        synchronized(this._componentFactoryMap) {
            this._componentFactoryMap[clazz] = factory
        }
    }

    @JvmStatic
    operator fun <T : Any> get(clazz: Class<T>): T {
        val directlyAccessInstanceInMap =
            synchronized(this._componentInstanceMap) { this._componentInstanceMap[clazz] }
        if (directlyAccessInstanceInMap != null) {
            return clazz.cast(directlyAccessInstanceInMap)
        }

        val componentFactory =
            synchronized(this._componentFactoryMap) { this._componentFactoryMap[clazz] }
        val componentInstance = componentFactory?.componentCreate()
        if (componentInstance != null) {
            val castInstance = clazz.cast(componentInstance)
            this[clazz] = castInstance
            return castInstance
        }

        throw NullPointerException("no instance or factories available for class: ${clazz}.")
    }

    fun componentExist(clazz: Class<*>): Boolean =
        synchronized(this._componentInstanceMap) { this._componentInstanceMap[clazz] != null }
}