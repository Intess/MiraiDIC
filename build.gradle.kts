plugins {
    val kotlinVersion = "1.6.20"
    kotlin("jvm") version kotlinVersion
    kotlin("plugin.serialization") version kotlinVersion

    id("net.mamoe.mirai-console") version "2.12.1"
}

group = "com.kagg886.miraidic"
version = "0.0.2"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}
