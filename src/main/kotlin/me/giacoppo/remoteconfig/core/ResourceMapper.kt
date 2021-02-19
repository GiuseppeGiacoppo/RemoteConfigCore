package me.giacoppo.remoteconfig.core

import java.io.InputStream

/**
 * Map the remote configuration class to repository class
 */
interface ResourceMapper {
    fun <T> toRepository(config: T): InputStream

    fun <T> fromRepository(config: InputStream, c: Class<T>): T
}
