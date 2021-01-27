package me.giacoppo.remoteconfig.core

/**
 * Defines how a resource can be fetched from a remote repository
 */
interface ResourceRemoteRepository<T> {
    fun fetch(
        success: (T) -> Unit,
        fail: (Exception) -> Unit
    )
}
