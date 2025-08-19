plugins {
    // this is necessary to avoid the plugins to be loaded multiple times
    // in each subproject's classloader
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.androidLibrary) apply false
    alias(libs.plugins.composeMultiplatform) apply false
    alias(libs.plugins.composeCompiler) apply false
    alias(libs.plugins.kotlinMultiplatform) apply false
    alias(libs.plugins.ktlint)
    alias(libs.plugins.detekt)
}

subprojects {
    apply(plugin = "org.jlleitschuh.gradle.ktlint")
    apply(plugin = "io.gitlab.arturbosch.detekt")

    detekt {
        buildUponDefaultConfig = true
        allRules = false
        source.setFrom(
            "src/commonMain/kotlin",
            "src/androidMain/kotlin",
            "src/iosMain/kotlin",
            "src/wasmJsMain/kotlin",
        )
    }

    ktlint {
        filter {
            include("**/src/**/*.kt")
            exclude { it.file.absolutePath.contains("build/generated") }
        }
    }
}
