package me.giacoppo.remoteconfig.core

import java.io.InputStream

/**
 * Defines how resources can be stored locally
 */
interface ResourceLocalRepository {
    fun setResourceName(resourceName: String)

    fun isFetchedFresh(maxAgeInMillis: Long): Boolean

    fun getActive(): InputStream?

    fun storeDefault(defaultValue: InputStream)

    fun storeFetched(fetchedResource: InputStream)

    fun activate()

    fun clear()
}
