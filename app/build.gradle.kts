// Copyright (C) 2026 Nicholas Doglio
// SPDX-License-Identifier: MIT

@file:OptIn(ExperimentalWasmDsl::class)

import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl

/*
 * Copyright (C) 2025 Nicholas Doglio
 * SPDX-License-Identifier: MIT
 */
plugins {
    alias(libs.plugins.convention.kmp)
    alias(libs.plugins.metro)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.compose.multiplatform)
}

compose.desktop { application { mainClass = "dev.whosnickdoglio.yahoofantasy.MainKt" } }

kotlin {
    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.foundation)
            implementation(libs.compose.material3)
            implementation(libs.compose.ui)
            implementation(libs.compose.ui.tooling.preview)
            //            implementation(libs.compose.ui.tooling)
            implementation(libs.circuit)
            implementation(libs.circuit.codegen.annotations)
        }
    }
}
