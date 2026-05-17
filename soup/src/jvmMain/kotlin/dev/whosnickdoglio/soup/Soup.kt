// Copyright (C) 2026 Nicholas Doglio
// SPDX-License-Identifier: MIT

package dev.whosnickdoglio.soup

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.network.parseGetRequestBlocking
import com.fleeksoft.ksoup.nodes.Element
import com.fleeksoft.ksoup.nodes.Node

public fun main() {
    val doc =
        Ksoup.parseGetRequestBlocking(
            "https://basketball.fantasysports.yahoo.com/2024/nba/40278/5/team?&date=2025-04-08"
        )

    val table = doc.find { element -> element.id() == "statTable0" }

    val rows: List<Element> = table?.selectNodes("tr").orEmpty<Node>().filterIsInstance<Element>()

    val info = rows.map { it.toPlayerRowRawInfo() }
    info.forEach { println(it) }
}

public fun Element.toPlayerRowRawInfo(): PlayerRowRawInfo {
    val elements = childElementsList().map { it.text() }
    return PlayerRowRawInfo(
        elements.getOrNull(0),
        elements.getOrNull(1),
        elements.getOrNull(2),
        elements.getOrNull(3),
    )
}

public data class PlayerRowRawInfo(
    val position: String?,
    val playerName: String?,
    val action: String?,
    val opponent: String?,
)
