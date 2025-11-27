package org.example.cmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform