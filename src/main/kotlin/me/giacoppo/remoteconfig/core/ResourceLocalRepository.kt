package me.giacoppo.remoteconfig.core

/**
 * Defines how resources can be stored locally
 */
interface ResourceLocalRepository<T> {
    fun setResourceName(resourceName: T)

    fun isFetchedFresh(maxAgeInMillis: Long): Boolean

    fun getActive(): T?

    fun storeDefault(defaultValue: T)

    fun storeFetched(fetchedResource: T, timestamp: Long)

    fun activate()

    fun clear()
}
