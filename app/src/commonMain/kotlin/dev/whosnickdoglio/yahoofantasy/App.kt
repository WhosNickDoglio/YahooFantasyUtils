/*
 * Copyright (C) 2025 Nicholas Doglio
 * SPDX-License-Identifier: MIT
 */

package dev.whosnickdoglio.yahoofantasy

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.slack.circuit.foundation.CircuitCompositionLocals
import com.slack.circuit.foundation.CircuitContent
import dev.whosnickdoglio.yahoofantasy.di.DependencyGraph
import dev.zacsweers.metro.createGraph

@Composable
public fun App() {
    val component = remember { createGraph<DependencyGraph>() }

    CircuitCompositionLocals(component.circuit) { MaterialTheme { CircuitContent(Home) } }
}
