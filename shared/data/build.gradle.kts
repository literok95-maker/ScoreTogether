plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    androidTarget()
    iosArm64()
    iosSimulatorArm64()
    wasmJs { browser() }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":shared:network"))
                implementation(project(":shared:db"))
                implementation(project(":shared:di"))
            }
        }
    }
}

android {
    namespace = "net.scoretogether.shared.data"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    defaultConfig { minSdk = libs.versions.android.minSdk.get().toInt() }
}
