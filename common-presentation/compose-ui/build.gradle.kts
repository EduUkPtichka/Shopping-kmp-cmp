import org.jetbrains.compose.ExperimentalComposeLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.jetbrainsCompose)
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
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.material3)
            implementation(compose.ui)

            // Kodein-Di
            implementation(libs.kodein.di.compose.framework.compose)

            //image url
            implementation(libs.composeImageLoader)
        }
    }
}


/* Как настраивать android
 * https://developer.android.com/build/configure-app-module#set-namespace
 * https://developer.android.com/build/agp-upgrade-assistant
 */

android {
    namespace = "common.compose.ui"

    compileSdk = (findProperty("android.compileSdk") as String).toInt()

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    dependencies {
        debugImplementation(libs.compose.ui.tooling)
    }
}