package com.example.myfirstkmpapp

import kotlinx.coroutines.*

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

fun main() = runBlocking{


}