plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinx.serialization)
}

kotlin {

    /* --- Explicit API ---*/

    // convenience methods
    explicitApi()
    // or
    explicitApiWarning()

    // setting level explicitly
    explicitApi = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Strict
    // or
    explicitApi = org.jetbrains.kotlin.gradle.dsl.ExplicitApiMode.Warning

    /* --------------------*/

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }

    sourceSets {

        commonMain.dependencies {

        }
    }
}

android {
    namespace = "common.model.layer"

    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
