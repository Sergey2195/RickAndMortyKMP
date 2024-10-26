package org.rick.and.morty

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform