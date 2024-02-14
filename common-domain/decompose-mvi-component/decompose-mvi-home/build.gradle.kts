plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {

    /* Настройте target-ы:
     * https://kotlinlang.org/docs/multiplatform-set-up-targets.html?utm_campaign=set-up-targets&utm_medium=kgp&utm_source=warnings
     */
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

            //Mvi
            implementation(libs.arkivanov.mvikotlin)
            implementation(libs.arkivanov.mvikotlin.main)
            implementation(libs.arkivanov.mvikotlin.extensions.coroutines)
            implementation(libs.arkivanov.mvikotlin.logging)
            implementation(libs.arkivanov.mvikotlin.timetravel)

            //Decompose
            implementation(libs.arkivanov.decompose.extension.compose)

            // Kodein-Di
            implementation(libs.kodein.di)


        }

    }
}


/* Как настраивать android
 * https://developer.android.com/build/configure-app-module#set-namespace
 * https://developer.android.com/build/agp-upgrade-assistant
 */

android {
    namespace = "common.decompose_mvi.logic_layer"

    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}