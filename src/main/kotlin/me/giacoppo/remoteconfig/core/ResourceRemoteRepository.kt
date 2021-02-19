package me.giacoppo.remoteconfig.core

import java.io.InputStream

/**
 * Defines how a resource can be fetched from a remote repository
 */
interface ResourceRemoteRepository {
    fun fetch(
        success: (InputStream) -> Unit,
        fail: (Exception) -> Unit
    )
}
