/*
 * Copyright (C) 2025 Nicholas Doglio
 * SPDX-License-Identifier: MIT
 */

package dev.whosnickdoglio.yahoofantasy

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.slack.circuit.codegen.annotations.CircuitInject
import com.slack.circuit.runtime.CircuitUiEvent
import com.slack.circuit.runtime.CircuitUiState
import com.slack.circuit.runtime.screen.Screen
import dev.zacsweers.metro.AppScope

public data object Home : Screen {

    public data class State(val hello: String, val onEvent: (Event) -> Unit) : CircuitUiState

    public sealed interface Event : CircuitUiEvent
}

@CircuitInject(Home::class, AppScope::class)
@Composable
public fun HomeScreen(state: Home.State, modifier: Modifier = Modifier) {
    Column(modifier = modifier) { Text(state.hello) }
}

@CircuitInject(Home::class, AppScope::class)
@Composable
public fun HomePresenter(): Home.State = Home.State("Hello Wheat Thin", {})
