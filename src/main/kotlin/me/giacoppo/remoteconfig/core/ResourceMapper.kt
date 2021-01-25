package me.giacoppo.remoteconfig.core

/**
 * It is used to map the remote configuration class to repository class
 */
interface ResourceMapper<T, F> {
    fun toRepository(config: Any): F

    fun fromRepository(config: F, c: Class<T>): T
}
