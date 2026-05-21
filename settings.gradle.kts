rootProject.name = "craft-engine-proxy"
include(":common")
include(":velocity")
include(":bungeecord")

pluginManagement {
    plugins {
        kotlin("jvm") version "2.3.10"
    }
    repositories {
        gradlePluginPortal()
        maven("https://repo.papermc.io/repository/maven-public/")
        maven("https://maven.fabricmc.net/")
    }
}

