import org.jetbrains.kotlin.config.ExplicitApiMode

plugins{
    id("detekt-convention")

    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.cocoapods.native.kotlin)
    alias(libs.plugins.skie)
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

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {

        commonMain.dependencies {
        implementation(libs.skie.annotations)
        }
    }

    cocoapods {
        version = "1.0"


        summary = "SKIE Demo Project"
        homepage = "https://github.com/touchlab/SKIEDemo"
        ios.deploymentTarget = "14"
    }
}