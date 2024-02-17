plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.jetbrainsCompose) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.cocoapods.native.kotlin) apply false
    alias(libs.plugins.skie) apply false
}

buildscript {
    dependencies {
        classpath(":build-logic")

    }
}