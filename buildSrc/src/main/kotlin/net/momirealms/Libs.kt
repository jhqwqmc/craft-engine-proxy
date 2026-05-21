package net.momirealms

import org.gradle.api.Project
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.plugins.JavaPlugin
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.exclude

/**
 * 获取依赖版本
 */
fun Project.ver(key: String): String {
    return rootProject.properties[key].toString()
}

fun DependencyHandlerScope.nbt(project: Project, configuration: String = JavaPlugin.COMPILE_ONLY_CONFIGURATION_NAME) {
    configuration("net.momirealms:sparrow-nbt:${project.ver("sparrow_nbt_version")}")
    configuration("net.momirealms:sparrow-nbt-adventure:${project.ver("sparrow_nbt_version")}")
    configuration("net.momirealms:sparrow-nbt-codec:${project.ver("sparrow_nbt_version")}")
    configuration("net.momirealms:sparrow-nbt-legacy-codec:${project.ver("sparrow_nbt_version")}")
}

fun DependencyHandlerScope.netty(project: Project, configuration: String = JavaPlugin.COMPILE_ONLY_CONFIGURATION_NAME) {
    configuration("io.netty:netty-all:${project.ver("netty_version")}")
    configuration("io.netty:netty-codec-http:${project.ver("netty_version")}")
}

fun DependencyHandlerScope.adventure(project: Project, configuration: String = JavaPlugin.COMPILE_ONLY_CONFIGURATION_NAME) {
    configuration("net.kyori:adventure-api:${project.ver("adventure_bundle_version")}")
    configuration("net.kyori:adventure-text-minimessage:${project.ver("adventure_bundle_version")}")
    configuration("net.kyori:adventure-text-serializer-json-legacy-impl:${project.ver("adventure_bundle_version")}")
    configuration("net.kyori:adventure-text-serializer-legacy:${project.ver("adventure_bundle_version")}")
    configuration("net.kyori:adventure-text-serializer-gson:${project.ver("adventure_bundle_version")}").apply {
        (this as? ExternalModuleDependency)?.exclude("com.google.code.gson", "gson")
    }
}