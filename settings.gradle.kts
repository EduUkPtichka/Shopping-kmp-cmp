//rootProject.name = "Shopping-kmp-cmp"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

includeBuild("build-logic")

/* ----Common Base----*/
include("common-base")

/* ----Common Presentation ----*/
include(":common-presentation:compose-ui")

/* ----Common Domain---- */
include(":common-domain:decompose-mvi-component:decompose-mvi-home")
include(":common-domain:decompose-mvi-component:decompose-mvi-catalog")
include(":common-domain:decompose-mvi-component:decompose-mvi-massanger")
include(":common-domain:decompose-mvi-component:decompose-mvi-shopping")
include(":common-domain:decompose-mvi-component:decompose-mvi-profile")
include(":common-domain:decompose-mvi-component:decompose-mvi-auth")


/* ----Common Data----*/
include(":common-data-core") // ?
include(":common-data-remote") // Запросы и ответы от backend
// include(":common-data-local") // Запросы и ответы - от DB //Отличить

/* ----Common entities---- */
include(":common-entities")
include(":common-model")

/* ---- Test ---- */
include(":composeAppTest")
