plugins {
    alias(libs.plugins.convention.kmp)
    alias(libs.plugins.metro)
}

kotlin {
    jvm()
    sourceSets.jvmMain.dependencies {
        implementation(libs.ksoup)
        implementation(libs.ksoup.network)
    }
}
