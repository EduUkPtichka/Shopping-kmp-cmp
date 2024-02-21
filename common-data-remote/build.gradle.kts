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

            //Jetbrains
            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.logging)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.ktor.client.content.negotiation)

            // Arrow-kt
            implementation(libs.arrow.kt.core)
            implementation(libs.arrow.kt.fx.coroutines)

            // Multiplatform Setting
            implementation(libs.multiplatform.settings)
            implementation(libs.multiplatform.settings.coroutines)

            // Kodein: Di
            implementation(libs.kodein.di)

            /* --- Project --- */
            implementation(project(":common-entities"))
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.kotlinx.coroutines.android)
        }

//        iosMain.dependencies {
//            implementation(libs.ktor.client.darwin)
//        }


    }
}

android {
    namespace = "common.data.remote"

    compileSdk = 34

    defaultConfig {
        minSdk = 24
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
