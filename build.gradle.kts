// Copyright (C) 2026 Nicholas Doglio
// SPDX-License-Identifier: MIT

buildscript { dependencies { classpath(libs.burst) } }

plugins {
  alias(libs.plugins.detekt)
  alias(libs.plugins.dependencyAnalysis)
  //    alias(libs.plugins.doctor)
  alias(libs.plugins.ktfmt)
  alias(libs.plugins.convention.kmp) apply false
  alias(libs.plugins.kotlin.compose) apply false
  alias(libs.plugins.kotlin.compose.multiplatform) apply false
  alias(libs.plugins.kotlin.multiplatform) apply false
  alias(libs.plugins.kover) apply false
  alias(libs.plugins.sortDependencies) apply false
  alias(libs.plugins.metro) apply false
}

// https://docs.gradle.org/8.9/userguide/gradle_daemon.html#daemon_jvm_criteria
tasks.updateDaemonJvm.configure {
  languageVersion = JavaLanguageVersion.of(libs.versions.jdk.get())
  vendor = JvmVendorSpec.AZUL
}
