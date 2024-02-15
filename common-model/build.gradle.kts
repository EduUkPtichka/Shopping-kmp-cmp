plugins{
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.cocoapods.native.kotlin)
    alias(libs.plugins.skie)
}

kotlin {
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {

        commonMain.dependencies {
//        implementation(libs.kotlinx.coroutines.core)
//        implementation(libs.skie.annotations)
        }
    }

    cocoapods {
        version = "1.0"


        summary = "SKIE Demo Project"
        homepage = "https://github.com/touchlab/SKIEDemo"
        ios.deploymentTarget = "14"
    }
}