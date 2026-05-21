package net.momirealms

import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

open class RelocationExtension {
    open fun applyProxy(task: ShadowJar) {
        with(task) {
            val libs = "net.momirealms.craftengine.libraries"
            relocate("net.kyori", libs)
            relocate("it.unimi.dsi.fastutil", "$libs.fastutil")
            relocate("com.github.benmanes.caffeine", "$libs.caffeine")
            relocate("com.google.errorprone", "$libs.errorprone")
            relocate("org.jspecify", "$libs.jspecify")
            relocate("net.momirealms.sparrow.reflection", "$libs.reflection")
            relocate("net.momirealms.sparrow.nbt", "$libs.nbt")
        }
    }
}