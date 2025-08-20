import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        val wasmJsMain by getting {
            dependencies {
                implementation(compose.ui)
                implementation(libs.koin.core)
                implementation(project(":shared:app"))
                implementation(project(":shared:di"))
            }
        }
    }
}
