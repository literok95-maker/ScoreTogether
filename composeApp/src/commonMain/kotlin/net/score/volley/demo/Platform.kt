package net.score.volley.demo

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
